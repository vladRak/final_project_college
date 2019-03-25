package com.final_project_college.dao;

import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.domain.dto.SchoolExam;

import java.util.List;
import java.util.Optional;

public interface ApplicantDao extends GenericDao<Applicant> {

    List<Applicant> getApplicantsByName(String name);

    List<SchoolExam> getApplicantExams(long applicantId);

    Optional<Applicant> getApplicantByEmail(String email);
}
