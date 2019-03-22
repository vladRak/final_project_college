package com.final_project_college.dao;

import com.final_project_college.dto.College;

import java.util.List;

public interface CollegeDao extends GenericDao<College> {

//    Optional<College> addSpecialtyToCollege(long specialtyId, long collegeId);
//
//    Optional<College> removeSpecialtyFromCollege(long specialtyId, long collegeId);

    List<College> getCollegesByName(String collegeName);

    List<College> getCollegesBySpecialtyId(long specialtyId);
}
