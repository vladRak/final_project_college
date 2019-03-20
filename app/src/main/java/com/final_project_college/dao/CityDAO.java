package com.final_project_college.dao;

import com.final_project_college.dto.City;
import com.final_project_college.dto.College;

import java.util.List;

public interface CityDAO extends GenericDAO<City> {

    List<College> getCollegesByCityId(long cityId);
}
