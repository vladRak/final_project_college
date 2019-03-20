package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.jdbc.DefaultPreparedStatementParameterSetter;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.dao.util.impl.QueryManagerImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class MySQLAbstractDAO {

    protected final QueryManager queryManager;
    protected final ConnectionWrapper connection;

    MySQLAbstractDAO(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new QueryManagerImpl(
                new DefaultPreparedStatementParameterSetter(),
                ResourceBundle.getBundle("queriesSQL"),
                connection);
    }

    int getNumberOfRows(String queryName) throws SQLException {
        int numOfRows = 0;

        try (PreparedStatement ps = connection
                .prepareStatement(queryManager.getQuery(queryName))) {

            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    numOfRows = resultSet.getInt(1);
                }
            }
        }
        return numOfRows;
    }

//    ResultSet findAllPaginated(int start, int count, String queryName) throws SQLException {
//
//        try (PreparedStatement ps = connection
//                .prepareStatement(queryManager.getQuery(queryName))) {
//            ps.setInt(1, start);
//            ps.setInt(2, count);
//            return ps.executeQuery();
//        }
//    }
//
//    ResultSet findAll(String queryName) throws SQLException {
//
//        try (PreparedStatement ps = connection.prepareStatement(
//                queryManager.getQuery(queryName))) {
//            return ps.executeQuery();
//        }
//    }
//
//    ResultSet getEntityById(long id, String queryName) throws SQLException {
//
//        try (PreparedStatement ps = connection.prepareStatement(
//                queryManager.getQuery(queryName))) {
//            ps.setLong(1, id);
//            return ps.executeQuery();
//        }
//
//    }

    boolean deleteById(long id, String queryName) throws SQLException {
        boolean deleted = false;

        try (PreparedStatement ps = connection.prepareStatement(
                queryManager.getQuery(queryName))) {

            ps.setLong(1, id);
            int i = ps.executeUpdate();
            if (i > 0) deleted = true;
        }
        return deleted;
    }
}
