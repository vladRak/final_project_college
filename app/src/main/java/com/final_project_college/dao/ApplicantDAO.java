package com.final_project_college.dao;

import com.final_project_college.dto.Applicant;
import com.final_project_college.exception.DataAccessException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ApplicantDAO extends GenericDAO<Applicant> {

    List<Applicant> getApplicantsByName(String name) throws DataAccessException;

    List<Applicant> getApplicantsByCollegeId(long collegeId);

    List<Applicant> getApplicantsByRating();

    List<Applicant> getApplicantsWithConcreteRating(BigDecimal rating);

    Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId);

    Optional<Applicant> getApplicantByExemptionId(long exemptionId);
}
