package com.final_project_college.dao;

import com.final_project_college.persistence.dto.Applicant;
import com.final_project_college.exception.DataAccessException;

import java.util.List;
import java.util.Optional;

public interface ApplicantDao extends GenericDao<Applicant> {

    List<Applicant> getApplicantsByName(String name) throws DataAccessException;

    List<Applicant> getApplicantsByCollegeId(long collegeId);

    Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId);
}
