package com.final_project_college.dao.jdbc;

import com.final_project_college.dao.jdbc.impl.ConnectionWrapper;

import java.sql.SQLException;
import java.sql.Savepoint;

public interface TransactionManager {

    ConnectionWrapper getConnection() throws SQLException;

    void beginTransaction() throws SQLException;

    Savepoint setSavepoint() throws SQLException;

    void rollback() throws SQLException;

    void commit() throws SQLException;

    void closeConnection() throws SQLException;
}
