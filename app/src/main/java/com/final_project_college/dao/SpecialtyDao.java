package com.final_project_college.dao;

import com.final_project_college.domain.dto.Specialty;

import java.util.List;
import java.util.Optional;

public interface SpecialtyDao extends GenericDao<Specialty> {

//    Optional<Specialty> addCollegeToSpecialty(long collegeId, long specialtyId);
//
//    Optional<Specialty> removeCollegeFromSpecialty(long collegeId, long specialtyId);

    Optional<Specialty> getSpecialtyByExamId(long examId);

    List<Specialty> getSpecialtiesByCollegeId(long collegeId);
}
