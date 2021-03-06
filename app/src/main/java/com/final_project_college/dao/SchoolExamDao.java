package com.final_project_college.dao;

import com.final_project_college.domain.dto.SchoolExam;

import java.util.List;
import java.util.Optional;

public interface SchoolExamDao extends GenericDao<SchoolExam> {

    List<SchoolExam> getSchoolExamsByApplicantId(long applicantId);

    List<SchoolExam> getSchoolExamsByExamSubjectId(long examSubjectId);

    Optional<SchoolExam> getSchoolExamByEmail(String email);
}
