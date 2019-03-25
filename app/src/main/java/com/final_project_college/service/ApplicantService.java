package com.final_project_college.service;

import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.DataAccessException;


public interface ApplicantService extends GenericService<Applicant> {

    Applicant registerApplicant(Applicant applicant, User user) throws DataAccessException;
}
