package com.final_project_college.dao;

import com.final_project_college.dto.*;

import java.util.List;
import java.util.Optional;

public interface SpecialtyDAO extends GenericDAO<Specialty> {

//    Optional<Specialty> addCollegeToSpecialty(long collegeId, long specialtyId);
//
//    Optional<Specialty> removeCollegeFromSpecialty(long collegeId, long specialtyId);

    Optional<Specialty> getSpecialtyByExamId(long examId);

    List<Specialty> getSpecialtiesByCollegeId(long collegeId);

    List<Specialty> getSpecialtiesByBranchId(long branchId);
}
