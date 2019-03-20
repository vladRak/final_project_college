package com.final_project_college.dao;

import com.final_project_college.dto.EntranceExam;
import com.final_project_college.dto.Specialty;

import java.util.Optional;

public interface EntranceExamDAO extends GenericDAO<EntranceExam> {

    Optional<Specialty> getSpecialtyByExamId(long examId);
}
