package com.final_project_college.service;

public interface AbstractServiceFactory {

    ApplicantService getApplicantService();

    ApplicationService getApplicationService();

    EntranceExamService getEntranceExamService();

    RoleService getRoleService();

    SchoolExamService getSchoolExamService();

    SpecialtyService getSpecialtyService();

    UserService getUserService();
}