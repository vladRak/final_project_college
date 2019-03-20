package com.final_project_college.dao.jdbc;

import com.final_project_college.exception.DataAccessException;

import java.util.List;

public interface JdbcManager {
    <T> List<T> select(String sql, RowMapper<T> rowMapper, Object... parameters) throws DataAccessException;

    long insertAndGetId(final String sql, final Object... parameters) throws DataAccessException;

    int update(final String sql, final Object... parameters) throws DataAccessException;
}
