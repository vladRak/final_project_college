package com.final_project_college.dao;

import com.final_project_college.domain.dto.EntranceExam;

import java.sql.SQLException;
import java.util.List;

public interface EntranceExamDao extends GenericDao<EntranceExam> {

    List<EntranceExam> getEntranceExamsBySpecialtyId(long specialtyId) throws SQLException;

    List<EntranceExam> getEntranceExamsByExamSubjectId(long examSubjectId) throws SQLException;
}
