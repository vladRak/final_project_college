package com.final_project_college.dao;

import com.final_project_college.dto.College;

import java.util.List;
import java.util.Optional;

public interface CollegeDAO extends GenericDAO<College> {

//    Optional<College> addSpecialtyToCollege(long specialtyId, long collegeId);
//
//    Optional<College> removeSpecialtyFromCollege(long specialtyId, long collegeId);

    List<College> getCollegesByName(String collegeName);

    List<College> getCollegesByBranchId(long branchId);

    List<College> getCollegesBySpecialtyId(long specialtyId);

    List<College> getCollegesByCityId(long cityId);

    List<College> getCollegesByRegionId(long regionId);
}
