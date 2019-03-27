package com.final_project_college.service;

import com.final_project_college.domain.dto.SchoolExam;
import com.final_project_college.exception.DataAccessException;

public interface SchoolExamService extends GenericService<SchoolExam>{
    SchoolExam addSchoolExam(SchoolExam schoolExam, String email) throws DataAccessException;

    boolean deleteSchoolExam(long schoolExamId, String email) throws DataAccessException;

    SchoolExam updateSchoolExam(SchoolExam exam, String email) throws DataAccessException;
}
