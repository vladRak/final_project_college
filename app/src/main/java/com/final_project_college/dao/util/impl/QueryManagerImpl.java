package com.final_project_college.dao.util.impl;

import com.final_project_college.connection.ConnectionWrapper;
import com.final_project_college.dao.jdbc.PreparedStatementParameterSetter;
import com.final_project_college.dao.jdbc.RowMapper;
import com.final_project_college.dao.util.QueryManager;
import com.final_project_college.exception.DataAccessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class QueryManagerImpl implements QueryManager {

    private final ResourceBundle resourceBundle;// = ResourceBundle.getBundle("queriesSQL");
    private final PreparedStatementParameterSetter preparedStatementParameterSetter;
    private final ConnectionWrapper connection;

    public QueryManagerImpl(final PreparedStatementParameterSetter preparedStatementParameterSetter,
                            final ResourceBundle resourceBundle,
                            final ConnectionWrapper connection) {
        this.resourceBundle = resourceBundle;
        this.preparedStatementParameterSetter = preparedStatementParameterSetter;
        this.connection = connection;
    }

    @Override
    public String getQuery(String key) {
        return resourceBundle.getString(key);
    }

    @Override
    public <T> List<T> select(final String sql, final RowMapper<T> rowMapper, final Object... parameters)
            throws SQLException {

        final List<T> result;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            preparedStatementParameterSetter.setParameters(ps, parameters);
            try (ResultSet resultSet = ps.executeQuery()) {
                result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(rowMapper.map(resultSet));
                }
            }
        }
        return result;
    }

    @Override
    public long insertAndGetId(final String sql, final Object... parameters)
            throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatementParameterSetter.setParameters(ps, parameters);
            long generatedId = -1L;
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong("id");
//                    generatedId = generatedKeys.getLong(1);
                }
            }

            if (-1 == generatedId) {
                throw new SQLException("No id is returned");
            }
            return generatedId;
        }
    }

    @Override
    public int update(final String sql, final Object... parameters)
            throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            preparedStatementParameterSetter.setParameters(ps, parameters);
            int result = ps.executeUpdate();
            if (0 < result) return result;
            else throw new SQLException("No row(s) is updated");
        }
    }
}