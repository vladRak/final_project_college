package com.final_project_college.dao;

import com.final_project_college.domain.dto.Application;

import java.util.List;

public interface ApplicationDao extends GenericDao<Application> {

    List<Application> getApplicationsByApplicantEmail(String email);

    List<Application> getApplicationsByApplicantId(long applicantId);

    List<Application> getApplicationsBySpecialtyId(long specialtyId);

    List<Application> getApplicationsByStatusId(long statusId);
}
