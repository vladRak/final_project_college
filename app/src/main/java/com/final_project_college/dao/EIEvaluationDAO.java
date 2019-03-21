package com.final_project_college.dao;

import com.final_project_college.dto.EIEvaluation;

import java.util.Optional;

public interface EIEvaluationDAO extends GenericDAO<EIEvaluation> {

    Optional<EIEvaluation> getEIEvaluationBySchoolExamId(long schoolExamId);

}
