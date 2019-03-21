package com.final_project_college.dao;

import com.final_project_college.dto.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchDAO extends GenericDAO<Branch> {

    Optional<Branch> getBranchBySpecialtyId(long specialtyId);

    List<Branch> getBranchesByCollegeId(long collegeId);
}
