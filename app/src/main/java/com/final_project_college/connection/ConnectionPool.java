package com.final_project_college.connection;

import com.final_project_college.exception.DataAccessException;

import java.sql.SQLException;

public interface ConnectionPool {
    ConnectionWrapper getConnection() throws SQLException;

    void closeConnection(ConnectionWrapper connection) throws SQLException, DataAccessException;
}
