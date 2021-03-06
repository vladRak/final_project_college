package com.final_project_college.util;

import com.final_project_college.domain.dto.*;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessCode;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.util.mail.MailSender;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class ServiceUtil {
    private static final int PASSED_EXAMS = 3;
    private static final int MAX_APPLICATION = 3;
    private static final int MIN_SCHOOL_EXAMS = 3;

    public static boolean checkPassedExams(List<SchoolExam> schoolExams, List<EntranceExam> entranceExams) {
        final int[] count = {0};
        schoolExams.forEach((schoolExam) -> {
            entranceExams.forEach((entranceExam) -> {
                if (schoolExam.getExamSubjectId() == entranceExam.getExamSubjectId() &&
                        schoolExam.getRating() > entranceExam.getMinRating()) {
                    count[0]++;
                }
            });
        });

        if (count[0] >= PASSED_EXAMS) {
            return true;
        } else throw new BusinessException(
                "You do not have required exams.",
                BusinessCode.INCORRECT_INPUT);
    }

    public static boolean checkMinSchoolExams(List<SchoolExam> schoolExams) {
        if (schoolExams.size() >= MIN_SCHOOL_EXAMS) {
            return true;
        } else throw new BusinessException(
                "Add your school exams to account",
                BusinessCode.INCORRECT_INPUT);
    }

    public static boolean checkApplicationCapacity(List<Application> applications) {
        if (applications.size() < MAX_APPLICATION) {
            return true;
        } else throw new BusinessException(
                "You have " + MAX_APPLICATION + ". This is maximum.",
                BusinessCode.INCORRECT_INPUT);
    }

    public static List<Application> checkApplicationExist(List<Application> applications, long specialtyId) {
        applications.forEach((application) -> {
                    if (application.getSpecialtyId() == specialtyId)
                        throw new BusinessException(
                                "You have application to this specialty",
                                BusinessCode.INCORRECT_INPUT);
                }
        );
        return applications;
    }

    public static String getNewHash() {
        return HashingUtil.hash(
                new Timestamp(System.currentTimeMillis()).toString());
    }

    public static boolean validateHash(String hash1, String hash2) {
        return HashingUtil.verifyValue(hash1, hash2);
    }

    public static Optional<String> createLinkToVerify(String contextPath, String hash) {
        try {
            String host = InetAddress.getLocalHost().getCanonicalHostName();
            return Optional.ofNullable(String.format("http://%s:%s%s", host, contextPath));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static Optional<String> sendInvitationMail(User user, Specialty specialty) {
        return new MailSender().sendMail(user.getEMail(), "Congratulations",
                "You are pass exams to specialty " + specialty.getSpecialtyName());
    }

    public static boolean validateSpecialtyInvitation(Specialty specialty) {
        if (specialty.isSendInvitations()) {
            throw new BusinessException(
                    "Invitations was send",
                    BusinessCode.INVITATION_SEND);
        } else return false;
    }

    public static Optional<String> sendVerificationMail(String email, String path, String hash)
            throws DataAccessException {
        return new MailSender().sendMail(email,
                "Please confirm email",
                createLinkToVerify(path, hash)
                        .orElseThrow(() -> new DataAccessException(DataAccessCode.INTERNAL_EXCEPTION)));
    }

    public static boolean validApplicationId(List<Application> applications, long id) {
        if (applications.isEmpty()) throw new BusinessException("Invalid id", BusinessCode.BAD_REQUEST);
        final boolean[] exist = new boolean[1];
        applications.forEach((a) -> {
            if(a.getId() == id) exist[0] = true;
            else throw new BusinessException("Invalid id", BusinessCode.BAD_REQUEST);
        });
        return exist[0];
    }
}
