package com.final_project_college.dao;

import com.final_project_college.domain.dto.ApplicationStatus;

import java.util.Optional;

public interface ApplicationStatusDao extends GenericDao<ApplicationStatus> {
    Optional<ApplicationStatus> getByName(String statusName);
}
