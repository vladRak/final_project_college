package com.final_project_college.dao.transactions;

import com.final_project_college.connection.ConnectionPool;
import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.jdbc.impl.DefaultTransactionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.mockito.Mockito.*;

public class TransactionManagerTest {
    ConnectionPool connectionPool;
    DefaultTransactionManager transactionManager;
    Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = mock(Connection.class);
        connectionPool = mock(ConnectionPool.class);
        transactionManager = new DefaultTransactionManager(connectionPool);
    }

    @After
    public void tearDown() throws Exception {
        connection = null;
        connectionPool = null;
        transactionManager = null;
    }

    @Test
    public void beginTransaction() throws Exception {
        when(connectionPool.getConnection()).thenReturn(new ConnectionWrapper(connection));

        for (int i = 0; i < 2; i++) {
            transactionManager.getConnection();
            transactionManager.beginTransaction();
            transactionManager.commit();
            transactionManager.closeConnection();
        }

        verify(connectionPool, times(2)).getConnection();
        verify(connection, times(2)).commit();
        verify(connectionPool, times(2)).closeConnection(anyObject());
    }
}