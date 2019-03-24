package com.final_project_college.dao;

import com.final_project_college.domain.dto.Specialty;

import java.util.Optional;

public interface SpecialtyDao extends GenericDao<Specialty> {

    Optional<Specialty> getSpecialtyByExamId(long examId);
}
