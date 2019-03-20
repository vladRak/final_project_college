package com.final_project_college.dao;

import com.final_project_college.dto.City;
import com.final_project_college.dto.College;
import com.final_project_college.dto.Region;

import java.util.List;

public interface RegionDAO extends GenericDAO<Region> {

    List<City> getCitiesByRegionId(long regionId);
    List<College> getCollegesByRegionId(long regionId);
}
