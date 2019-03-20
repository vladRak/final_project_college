package com.final_project_college.dao;

import com.final_project_college.dto.*;

import java.util.List;
import java.util.Optional;

public interface SpecialtyDAO extends GenericDAO< Specialty> {

    Optional<Specialty> addCollegeToSpecialty(long collegeId, long specialtyId);
    Optional<Specialty> removeCollegeFromSpecialty(long collegeId, long specialtyId);
    Optional<Branch> getBranchBySpecialtyId(long specialtyId);
    List<College> getCollegesBySpecialtyId(long specialtyId);
    List<Application> getApplicationsBySpecialtyId(long specialtyId);
    List<EntranceExam> getEntranceExamsBySpecialtyId(long specialtyId);
}
