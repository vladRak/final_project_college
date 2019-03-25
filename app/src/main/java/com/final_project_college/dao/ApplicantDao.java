package com.final_project_college.dao;

import com.final_project_college.domain.dto.Applicant;

import java.util.List;
import java.util.Optional;

public interface ApplicantDao extends GenericDao<Applicant> {

    List<Applicant> getApplicantsByName(String name);

    Optional<Applicant> getApplicantBySchoolExamId(long schoolExamId);
}
