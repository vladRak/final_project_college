package com.final_project_college.dao;

import com.final_project_college.dto.Application;
import com.final_project_college.dto.ApplicationStatus;

import java.util.List;

public interface ApplicationStatusDAO extends GenericDAO<ApplicationStatus> {

    List<Application> getApplicationsByStatusId(long statusId);
}
