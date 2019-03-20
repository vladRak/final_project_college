package com.final_project_college.dao;

import com.final_project_college.dto.Certificate;
import com.final_project_college.dto.Applicant;

import java.math.BigDecimal;
import java.util.List;

public interface CertificateDAO extends GenericDAO<Certificate> {

    List<Applicant> getApplicantsByRating();
    List<Applicant> getApplicantsWithConcreteRating(BigDecimal rating);
}
