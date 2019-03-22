package com.final_project_college.dao;

import com.final_project_college.persistence.dto.CollegeSpecialty;

import java.util.List;

public interface CollegeSpecialtyDao extends GenericDao<CollegeSpecialty> {

    List<CollegeSpecialty> getCollegeSpecialtiesByCollegeId(long collegeId);
}
