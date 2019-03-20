package com.final_project_college.dao;

import com.final_project_college.dto.Application;
import com.final_project_college.exception.DataAccessException;

import java.util.List;
import java.util.Optional;

public interface ApplicationDAO extends GenericDAO<Application> {

    Optional<Application> deactivate(long applicationId);
    Optional<Application> changeStatus(long applicationId, long statusId);
    List<Application> getApplicationsByApplicantId(long applicantId) throws DataAccessException;
}
