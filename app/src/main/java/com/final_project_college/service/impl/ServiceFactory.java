package com.final_project_college.service.impl;

import com.final_project_college.service.*;

public class ServiceFactory implements AbstractServiceFactory {

    @Override
    public ApplicantService getApplicantService() {
        return new ApplicantServiceImpl();
    }

    @Override
    public ApplicationService getApplicationService() {
        return new ApplicationServiceImpl();
    }

    @Override
    public ApplicationStatusService getApplicationStatusService() {
        return new ApplicationStatusServiceImpl();
    }

    @Override
    public EntranceExamService getEntranceExamService() {
        return new EntranceExamServiceImpl();
    }

    @Override
    public RoleService getRoleService() {
        return new RoleServiceImpl();
    }

    @Override
    public SchoolExamService getSchoolExamService() {
        return new SchoolExamServiceImpl();
    }

    @Override
    public SpecialtyService getSpecialtyService() {
        return new SpecialtyServiceImpl();
    }

    @Override
    public UserService getUserService() {
        return new UserServiceImpl();
    }
}
