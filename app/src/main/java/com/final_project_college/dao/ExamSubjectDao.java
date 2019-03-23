package com.final_project_college.dao;

import com.final_project_college.domain.dto.ExamSubject;

import java.sql.SQLException;
import java.util.Optional;

public interface ExamSubjectDao extends GenericDao<ExamSubject> {

    Optional<ExamSubject> getExamSubjectBySchoolExamId(long schoolExamId) throws SQLException;

    Optional<ExamSubject> getExamSubjectByEntranceExamId(long entranceExamId) throws SQLException;
}
