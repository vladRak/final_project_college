package com.final_project_college.util;

import com.final_project_college.domain.dto.*;
import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class ControllerUtil {

    private final static Pattern string = Pattern.compile("\\w{1,255}");
    private final static Pattern integer = Pattern.compile("[0-9]+");
    private final static Pattern email = Pattern.compile("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)");
    private final static Pattern password = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    private final static Pattern decimal = Pattern.compile("[0-9]*[.]?[0-9]*");
    private final static Pattern certificateRating = Pattern.compile("^[1][12][.]?[0-9]{0,2}");
    private final static Pattern schoolExamRating = Pattern.compile("");

    public static User validateUser(Map<String, String[]> parameters) {
        return User.builder()
                .firstName(validate(getValue("firstName", parameters), "firstName", string))
                .lastName(validate(getValue("lastName", parameters), "lastName", string))
                .eMail(validate(getValue("email", parameters), "email", email))
                .password(validate(getValue("password", parameters), "password", password))
                .roleId(Long.parseLong(validate(getValue("roleId", parameters), "roleId", integer)))
                .build();
    }

    public static Specialty validateSpecialty(Map<String, String[]> parameters) {
        return Specialty.builder()
                .specialtyName(validate(getValue("specialtyName", parameters), "specialtyName", string))
                .governmentOrder(Integer.parseInt(validate(getValue("governmentOrder", parameters), "governmentOrder", integer)))
                .build();
    }

    public static SchoolExam validateSchoolExam(Map<String, String[]> parameters) {
        return SchoolExam.builder()
                .rating(Short.parseShort(validate(getValue("rating", parameters), "rating", integer)))
                .examSubjectId(Integer.parseInt(validate(getValue("examSubjectId", parameters), "examSubjectId", integer)))
//                .applicantId(Integer.parseInt(validate(getValue("applicantId", parameters), "applicantId", integer)))
                .build();
    }

    public static Role validateRole(Map<String, String[]> parameters) {
        return Role.builder()
                .roleName(validate(getValue("roleName", parameters), "roleName", string))
                .build();
    }

    public static EntranceExam validateEntranceExam(Map<String, String[]> parameters) {
        return EntranceExam.builder()
                .minRating(Short.parseShort(validate(getValue("minRating", parameters), "minRating", integer)))
                .examSubjectId(Integer.parseInt(validate(getValue("examSubjectId", parameters), "examSubjectId", integer)))
                .specialtyId(Integer.parseInt(validate(getValue("specialtyId", parameters), "specialtyId", integer)))
                .build();
    }

    public static Application validateApplication(Map<String, String[]> parameters) {
        return Application.builder()
                .specialtyId(Integer.parseInt(validate(getValue("specialtyId", parameters), "specialtyId", integer)))
                .build();
    }

    public static Applicant validateApplicant(Map<String, String[]> parameters) {
        return Applicant.builder()
                .certificateRating(BigDecimal.valueOf(
                        Double.valueOf(
                                validate(getValue("certificateRating", parameters), "certificateRating", decimal))))
                .build();
    }

    public static long getValidId(String param) {
        try {
            return Long.parseLong(Optional.ofNullable(param).orElseThrow(() ->
                    new BusinessException("Invalid id",
                            BusinessCode.INCORRECT_INPUT)));
        }catch (NumberFormatException e){
            throw new BusinessException("Invalid id",
                    BusinessCode.INCORRECT_INPUT);
        }
    }

    private static String validate(String param, String msg, Pattern pattern) {
        if (pattern.matcher(param).find()) return param;
        else throw new BusinessException(msg, BusinessCode.INCORRECT_INPUT);
    }

    private static String getValue(String value, Map<String, String[]> parameters) {
        String[] params = parameters.get(value);
        if (params.length == 1) {
            return params[0];
        } else throw new BusinessException("To many values", BusinessCode.INCORRECT_INPUT);
    }
}
