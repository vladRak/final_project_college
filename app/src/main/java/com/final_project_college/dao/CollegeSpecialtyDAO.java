package com.final_project_college.dao;

import com.final_project_college.dto.CollegeSpecialty;

import java.util.List;

public interface CollegeSpecialtyDAO extends GenericDAO<CollegeSpecialty>{

    List<CollegeSpecialty> getCollegeSpecialtiesByCollegeId(long collegeId);
}