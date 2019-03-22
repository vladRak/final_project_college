package com.final_project_college.dao;

import com.final_project_college.dto.Application;
import com.final_project_college.exception.DataAccessException;

import java.util.List;

public interface ApplicationDao extends GenericDao<Application> {

    List<Application> getApplicationsByApplicantId(long applicantId) throws DataAccessException;

    List<Application> getApplicationsByCollegeId(long collegeId);

    List<Application> getApplicationsBySpecialtyId(long specialtyId);

    List<Application> getApplicationsByStatusId(long statusId);
}
