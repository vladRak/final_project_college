package com.final_project_college.dao;

import com.final_project_college.domain.dto.CollegeSpecialty;

import java.sql.SQLException;
import java.util.List;

public interface CollegeSpecialtyDao extends GenericDao<CollegeSpecialty> {

    List<CollegeSpecialty> getCollegeSpecialtiesByCollegeId(long collegeId) throws SQLException;
}
