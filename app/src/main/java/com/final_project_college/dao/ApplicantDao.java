package com.final_project_college.dao;

import com.final_project_college.domain.dto.Applicant;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ApplicantDao extends GenericDao<Applicant>, FunctionalDao<Applicant> {

    List<Applicant> getApplicantsByName(String name) throws SQLException;

    Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId) throws SQLException;
}
