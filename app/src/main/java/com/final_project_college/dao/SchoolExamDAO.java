package com.final_project_college.dao;

import com.final_project_college.dto.Applicant;
import com.final_project_college.dto.EIEvaluation;
import com.final_project_college.dto.ExamSubject;
import com.final_project_college.dto.SchoolExam;

import java.util.Optional;

public interface SchoolExamDAO extends GenericDAO<SchoolExam> {

    Optional<ExamSubject> getExamSubjectBySchoolExamId(long schoolExamId);
    Optional<EIEvaluation> getEIEvaluationBySchoolExamId(long schoolExamId);
    Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId);
}
