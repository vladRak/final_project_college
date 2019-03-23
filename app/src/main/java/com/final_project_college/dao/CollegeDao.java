package com.final_project_college.dao;

import com.final_project_college.domain.dto.College;

import java.sql.SQLException;
import java.util.List;

public interface CollegeDao extends GenericDao<College> {

//    Optional<College> addSpecialtyToCollege(long specialtyId, long collegeId);
//
//    Optional<College> removeSpecialtyFromCollege(long specialtyId, long collegeId);

    List<College> getCollegesByName(String collegeName) throws SQLException;

    List<College> getCollegesBySpecialtyId(long specialtyId) throws SQLException;
}
