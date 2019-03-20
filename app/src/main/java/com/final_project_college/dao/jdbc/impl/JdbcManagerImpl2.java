//package com.final_project_college.dao.jdbc.impl;
//
//import com.final_project_college.dao.jdbc.JdbcManager;
//import com.final_project_college.dao.jdbc.PreparedStatementParameterSetter;
//import com.final_project_college.dao.jdbc.RowMapper;
//import com.final_project_college.exception.DataAccessException;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class JdbcManagerImpl2 implements JdbcManager {
//
//    private final PreparedStatementParameterSetter preparedStatementParameterSetter;
//
//    public JdbcManagerImpl2(final PreparedStatementParameterSetter preparedStatementParameterSetter) {
//        this.preparedStatementParameterSetter = preparedStatementParameterSetter;
//
//    }
//
//    @Override
//    public <T> List<T> select(final String sql, final RowMapper<T> rowMapper, final Object... parameters)
//            throws DataAccessException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        final List<T> result = new ArrayList<T>();
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(sql);
//            preparedStatementParameterSetter.setParameters(statement, parameters);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                result.add(rowMapper.map(resultSet));
//            }
//        } catch (final SQLException e) {
//            throw new DataAccessOperationErrorException(e);
//        } finally {
//            closeQuietly(connection, statement, resultSet);
//        }
//        return result;
//    }
//
//    @Override
//    public long insertAndGetId(final String sql, final Object... parameters) throws DataAccessException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = getConnection();
//            connection.setAutoCommit(false);
//            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            preparedStatementParameterSetter.setParameters(statement, parameters);
//            final int result = statement.executeUpdate();
//            Long id = null;
//            if (0 != result) {
//                resultSet = statement.getGeneratedKeys();
//                if (resultSet.next()) {
//                    id = resultSet.getLong(1);
//                }
//            }
//            if (null == id) {
//                throw new DataAccessOperationErrorException("No id is returned");
//            }
//            connection.commit();
//            return id;
//        } catch (final DataAccessException e) {
//            rollback(connection);
//            throw e;
//        } catch (final Exception e) {
//            rollback(connection);
//            throw new DataAccessOperationErrorException(e);
//        } finally {
//            closeQuietly(connection, statement, resultSet);
//        }
//    }
//
//    @Override
//    public int update(final String sql, final Object... parameters) throws DataAccessException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        final ResultSet resultSet = null;
//
//        try {
//            connection = getConnection();
//            connection.setAutoCommit(false);
//            statement = connection.prepareStatement(sql);
//            preparedStatementParameterSetter.setParameters(statement, parameters);
//            final int result = statement.executeUpdate();
//            connection.commit();
//            return result;
//        } catch (final DataAccessException e) {
//            rollback(connection);
//            throw e;
//        } catch (final Exception e) {
//            rollback(connection);
//            throw new DataAccessOperationErrorException(e);
//        } finally {
//            closeQuietly(connection, statement, resultSet);
//        }
//    }
//}
