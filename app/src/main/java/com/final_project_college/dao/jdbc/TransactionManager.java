package com.final_project_college.dao.jdbc;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;

import java.sql.Savepoint;

public interface TransactionManager {

    ConnectionWrapper getConnection();

    void beginTransaction();

    Savepoint setSavepoint();

    void rollback();

    void commit();

    void closeConnection();
}
