package com.final_project_college.dao;

import com.final_project_college.domain.dto.Application;
import com.final_project_college.domain.dto.EntranceExam;
import com.final_project_college.domain.dto.Specialty;
import com.final_project_college.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface SpecialtyDao extends GenericDao<Specialty> {

    Optional<Specialty> getSpecialtyByExamId(long examId);

    List<EntranceExam> getEntranceExams(long specialtyId);

    boolean saveInvitation(long applicationId, long specialtyId);

    List<Application> getApplicationsToSendInvitations(long specialtyId, int governmentOrder);
}
