package com.final_project_college.dao;

import com.final_project_college.dto.ExamSubject;

import java.util.Optional;

public interface ExamSubjectDAO extends GenericDAO<ExamSubject> {

    Optional<ExamSubject> getExamSubjectBySchoolExamId(long schoolExamId);
}
