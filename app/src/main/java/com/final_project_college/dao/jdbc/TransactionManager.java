package com.final_project_college.dao.jdbc;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.exception.DataAccessException;

import java.sql.Savepoint;

public interface TransactionManager {

    ConnectionWrapper getConnection() throws DataAccessException;

    void beginTransaction() throws DataAccessException;

    Savepoint setSavepoint() throws DataAccessException;

    void rollback() throws DataAccessException;

    void commit() throws DataAccessException;

    void closeConnection() throws DataAccessException;
}
