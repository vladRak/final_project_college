package com.final_project_college.service;

import com.final_project_college.domain.dto.Applicant;
import com.final_project_college.domain.dto.SchoolExam;
import com.final_project_college.domain.dto.User;
import com.final_project_college.exception.SystemException;

import java.util.List;


public interface ApplicantService extends GenericService<Applicant> {

    Applicant registerApplicant(Applicant applicant, List<SchoolExam> schoolExams, User user) throws SystemException;
}
