package com.final_project_college.dao;

import com.final_project_college.dto.Branch;
import com.final_project_college.dto.College;
import com.final_project_college.dto.Specialty;

import java.util.List;

public interface BranchDAO extends GenericDAO<Branch> {

    List<Specialty> getSpecialtiesByBranchId(long branchId);
    List<College> getCollegesByBranchId(long branchId);
}
