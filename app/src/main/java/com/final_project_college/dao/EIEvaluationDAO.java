package com.final_project_college.dao;

import com.final_project_college.dto.EIEvaluation;
import com.final_project_college.dto.SchoolExam;

import java.util.List;

public interface EIEvaluationDAO extends GenericDAO<EIEvaluation> {

    List<SchoolExam> getEvaluationExams(long eIEvaluationId);
}
