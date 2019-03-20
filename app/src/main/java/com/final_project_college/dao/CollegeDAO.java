package com.final_project_college.dao;

import com.final_project_college.dto.*;

import java.util.List;
import java.util.Optional;

public interface CollegeDAO extends GenericDAO<College> {

    Optional<College> addSpecialtyToCollege(long specialtyId, long  collegeId);
    Optional<College> removeSpecialtyFromCollege(long specialtyId, long collegeId);
    List<College> getCollegesByName(String collegeName);
    List<Application> getApplicationsByCollegeId(long collegeId);
    List<Specialty> getSpecialtiesByCollegeId(long collegeId);
    List<Branch> getBranchesByCollegeId(long collegeId);
    List<Applicant> getApplicantsByCollegeId(long collegeId);
}
