package com.final_project_college.dao;

import com.final_project_college.dto.EntranceExam;

import java.util.List;

public interface EntranceExamDao extends GenericDao<EntranceExam> {

    List<EntranceExam> getEntranceExamsBySpecialtyId(long specialtyId);

    List<EntranceExam> getEntranceExamsByExamSubjectId(long examSubjectId);
}
