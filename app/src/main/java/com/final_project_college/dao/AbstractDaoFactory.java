package com.final_project_college.dao;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;

public interface AbstractDaoFactory {

    ApplicantDao getApplicantDao(ConnectionWrapper connection);

    ApplicationDao getApplicationDao(ConnectionWrapper connection);

    ApplicationStatusDao getApplicationStatusDao(ConnectionWrapper connection);

    CollegeDao getCollegeDao(ConnectionWrapper connection);

    CollegeSpecialtyDao getCollegeSpecialtyDao(ConnectionWrapper connection);

    EntranceExamDao getEntranceExamDao(ConnectionWrapper connection);

    ExamSubjectDao getExamSubjectDao(ConnectionWrapper connection);

    PrivilegeDao getPrivilegeDao(ConnectionWrapper connection);

    RoleDao getRoleDao(ConnectionWrapper connection);

    SchoolExamDao getSchoolExamDao(ConnectionWrapper connection);

    SpecialtyDao getSpecialtyDao(ConnectionWrapper connection);

    UserDao getUserDao(ConnectionWrapper connection);
}