package com.final_project_college.dao.transactions;

import com.final_project_college.connection.ConnectionPool;
import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.exception.DataAccessException;

import java.sql.SQLException;
import java.sql.Savepoint;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class TransactionManager {

    private final ThreadLocal<ConnectionWrapper> connections = new ThreadLocal<>();
    private final ConnectionPool connectionPool;

    public TransactionManager(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ConnectionWrapper getConnection() throws DataAccessException {
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

    public void beginTransaction() throws DataAccessException {
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

    public Savepoint setSavepoint() throws DataAccessException {
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

    public void rollback() throws DataAccessException {
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

    public void commit() throws DataAccessException {
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

    public void closeConnection() throws DataAccessException {
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