package com.final_project_college.dao;

import com.final_project_college.dto.City;

import java.util.List;

public interface CityDAO extends GenericDAO<City> {
    List<City> getCitiesByRegionId(long regionId);
}
