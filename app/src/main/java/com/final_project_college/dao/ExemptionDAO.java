package com.final_project_college.dao;

import com.final_project_college.dto.Applicant;
import com.final_project_college.dto.Exemption;

import java.util.Optional;

public interface ExemptionDAO extends GenericDAO<Exemption> {

    Optional<Applicant> getApplicantByExemptionId(long exemptionId);
}
