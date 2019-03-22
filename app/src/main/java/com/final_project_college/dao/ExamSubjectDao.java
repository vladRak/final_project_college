package com.final_project_college.dao;

import com.final_project_college.dto.ExamSubject;

import java.util.Optional;

public interface ExamSubjectDao extends GenericDao<ExamSubject> {

    Optional<ExamSubject> getExamSubjectBySchoolExamId(long schoolExamId);

    Optional<ExamSubject> getExamSubjectByEntranceExamId(long entranceExamId);
}
