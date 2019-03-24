package com.final_project_college.dao;

import com.final_project_college.domain.dto.Application;

import java.sql.SQLException;
import java.util.List;

public interface ApplicationDao extends GenericDao<Application> {

    List<Application> getApplicationsByApplicantId(long applicantId) throws SQLException;

    List<Application> getApplicationsBySpecialtyId(long specialtyId) throws SQLException;

    List<Application> getApplicationsByStatusId(long statusId) throws SQLException;
}
