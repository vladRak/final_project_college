package com.final_project_college.dao.jdbc.impl;

import com.final_project_college.dao.jdbc.ConnectionPool;
import com.final_project_college.dao.jdbc.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Optional;


public class DefaultTransactionManager implements TransactionManager {

    private final ThreadLocal<ConnectionWrapper> connections = new ThreadLocal<>();
    private final ConnectionPool connectionPool;
    private final String ERROR_MESSAGE = "Connection does not open";
    private static final Logger logger = LoggerFactory.getLogger(DefaultTransactionManager.class);

    public DefaultTransactionManager(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ConnectionWrapper getConnection() throws SQLException {

        connections.set(
                Optional.ofNullable(connections.get())
                        .orElse(connectionPool.getConnection()));
        return connections.get();
    }

    public void beginTransaction() throws SQLException {
        Optional.ofNullable(connections.get())
                .orElseThrow(() -> new SQLException(ERROR_MESSAGE))
                .setAutoCommit(false);
    }

    public Savepoint setSavepoint() throws SQLException {
        return Optional.ofNullable(connections.get())
                .orElseThrow(() -> new SQLException(ERROR_MESSAGE))
                .setSavepoint();
    }

    public void rollback() throws SQLException {
        Optional.ofNullable(connections.get())
                .orElseThrow(() -> new SQLException(ERROR_MESSAGE))
                .rollback();
    }

    public void commit() throws SQLException {
        Optional.ofNullable(connections.get())
                .orElseThrow(() -> new SQLException(ERROR_MESSAGE))
                .commit();
    }

    public void closeConnection() throws SQLException {
        Optional.ofNullable(connections.get())
                .orElseThrow(() -> new SQLException(ERROR_MESSAGE))
                .close();
        connections.set(null);
    }
}