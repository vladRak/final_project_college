package com.final_project_college.service;

import com.final_project_college.domain.dto.Application;
import com.final_project_college.domain.dto.Specialty;
import com.final_project_college.exception.DataAccessException;

import java.util.List;

public interface SpecialtyService extends GenericService<Specialty> {
    List<Application> sendInvitations(long specialtyId) throws DataAccessException;
}
