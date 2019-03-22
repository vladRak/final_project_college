package com.final_project_college.dao.jdbc.impl;

import com.final_project_college.dao.jdbc.ConnectionPool;
import com.final_project_college.exception.DataAccessException;

import java.sql.SQLException;
import java.sql.Savepoint;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class DefaultTransactionManager {

    private final ThreadLocal<ConnectionWrapper> connections = new ThreadLocal<>();
    private final ConnectionPool connectionPool;

    public DefaultTransactionManager(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ConnectionWrapper getConnection() {
        ConnectionWrapper connectionWrapper = connections.get();
        if (nonNull(connectionWrapper)) {
            return connectionWrapper;
        } else {
            try {
                connectionWrapper = connectionPool.getConnection();
                connectionWrapper
                        .getConnection()
                        .setAutoCommit(true);
                connections.set(connectionWrapper);
                return connectionWrapper;
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }
    }

    public void beginTransaction() {
        ConnectionWrapper connectionWrapper = connections.get();
        if (nonNull(connectionWrapper)) {
            try {
                connectionWrapper.getConnection().setAutoCommit(false);
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        } else {
            throw new DataAccessException();

        }
    }

    public Savepoint setSavepoint() {
        Savepoint savepoint;

        ConnectionWrapper connectionWrapper = connections.get();
        if (isNull(connectionWrapper)) {
            throw new DataAccessException();
        } else {
            try {
                savepoint = connectionWrapper
                        .getConnection()
                        .setSavepoint();
                return savepoint;
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }
    }

    public void rollback() {
        ConnectionWrapper connectionWrapper = connections.get();
        if (isNull(connectionWrapper)) {
            throw new DataAccessException();
        } else {
            try {
                connectionWrapper.getConnection().rollback();
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }
    }

    public void commit() {
        ConnectionWrapper connectionWrapper = connections.get();
        if (isNull(connectionWrapper)) {
            throw new DataAccessException();
        } else {
            try {
                connectionWrapper.getConnection().commit();
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
        }
    }

    public void closeConnection() {
        ConnectionWrapper connectionWrapper = connections.get();
        if (isNull(connectionWrapper)) {
            throw new DataAccessException();
        } else {
            try {
                connectionPool.closeConnection(connectionWrapper);
            } catch (SQLException e) {
                throw new DataAccessException(e);
            }
            connections.set(null);
        }
    }
}