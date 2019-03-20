package com.final_project_college.dao;

import com.final_project_college.dto.Applicant;
import com.final_project_college.exception.DataAccessException;

import java.util.List;

public interface ApplicantDAO extends GenericDAO<Applicant> {

    List<Applicant> getApplicantsByName(String name) throws DataAccessException;
}
