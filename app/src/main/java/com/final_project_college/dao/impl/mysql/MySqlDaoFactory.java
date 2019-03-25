package com.final_project_college.dao.impl.mysql;

import com.final_project_college.dao.*;
import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;

public class MySqlDaoFactory implements AbstractDaoFactory {

    @Override
    public ApplicantDao getApplicantDao(ConnectionWrapper connection) {
        return new MySqlApplicantDao(connection);
    }

    @Override
    public ApplicationDao getApplicationDao(ConnectionWrapper connection) {
        return new MySqlApplicationDao(connection);
    }

    @Override
    public ApplicationStatusDao getApplicationStatusDao(ConnectionWrapper connection) {
        return new MySqlApplicationStatusDao(connection);
    }

    @Override
    public EntranceExamDao getEntranceExamDao(ConnectionWrapper connection) {
        return new MySqlEntranceExamDao(connection);
    }

    @Override
    public ExamSubjectDao getExamSubjectDao(ConnectionWrapper connection) {
        return new MySqlExamSubjectDao(connection);
    }

    @Override
    public RoleDao getRoleDao(ConnectionWrapper connection) {
        return new MySqlRoleDao(connection);
    }

    @Override
    public SchoolExamDao getSchoolExamDao(ConnectionWrapper connection) {
        return new MySqlSchoolExamDao(connection);
    }

    @Override
    public SpecialtyDao getSpecialtyDao(ConnectionWrapper connection) {
        return new MySqlSpecialtyDao(connection);
    }

    @Override
    public UserDao getUserDao(ConnectionWrapper connection) {
        return new MySqlUserDao(connection);
    }
}
