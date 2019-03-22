package com.final_project_college.dao.jdbc.impl;


import com.final_project_college.dao.jdbc.ConnectionPool;
import com.final_project_college.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;

public enum ConnectionPoolImpl implements ConnectionPool {

    INSTANCE;

    private static final String DATASOURCE_NAME = "jdbc/exposition_calendar";
    private static Context initContext;
    private static Context envContext;
    private static DataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolImpl.class);

    static {
        try {
            initContext = new InitialContext();
            envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);

        } catch (NamingException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public ConnectionWrapper getConnection() throws SQLException {
        return new ConnectionWrapper(dataSource.getConnection());
    }

    @Override
    public void closeConnection(ConnectionWrapper connection) throws SQLException, DataAccessException {
        connection.close();
    }
}
