package com.final_project_college.dao;

import com.final_project_college.dto.EntranceExam;
import com.final_project_college.dto.ExamSubject;
import com.final_project_college.dto.SchoolExam;

import java.util.List;

public interface ExamSubjectDAO extends GenericDAO<ExamSubject> {

    List<SchoolExam> getSchoolExamsByExamSubjectId(long examSubjectId);
    List<EntranceExam> getEntranceExamsByExamSubjectId(long examSubjectId);
}
