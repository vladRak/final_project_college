package com.final_project_college.dao.impl.mysql;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.jdbc.impl.DefaultPreparedStatementParameterSetter;
import com.final_project_college.dao.jdbc.QueryManager;
import com.final_project_college.dao.jdbc.impl.DefaultQueryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class MySqlAbstractDao {

    protected final QueryManager queryManager;
    protected final ConnectionWrapper connection;

    MySqlAbstractDao(ConnectionWrapper connection) {
        this.connection = connection;
        queryManager = new DefaultQueryManager(
                new DefaultPreparedStatementParameterSetter(),
                ResourceBundle.getBundle("queriesSQL"),
                connection);
    }

    int getNumberOfRows(final String sql) throws SQLException {
        int numOfRows = 0;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    numOfRows = resultSet.getInt(1);
                }
            }
        }
        return numOfRows;
    }

    boolean deleteById(long id, String sql) throws SQLException {
        boolean deleted = false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            int i = ps.executeUpdate();
            if (i > 0) deleted = true;
        }
        return deleted;
    }
}
