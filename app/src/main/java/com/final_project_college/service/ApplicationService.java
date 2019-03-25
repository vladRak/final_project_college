package com.final_project_college.service;

import com.final_project_college.domain.dto.Application;
import com.final_project_college.exception.DataAccessException;

public interface ApplicationService extends GenericService<Application>{

    Application addApplication(Application application, String email) throws DataAccessException;
}
