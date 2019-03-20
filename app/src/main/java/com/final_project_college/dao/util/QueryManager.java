package com.final_project_college.dao.util;

import com.final_project_college.dao.jdbc.RowMapper;
import com.final_project_college.exception.DataAccessException;

import java.sql.SQLException;
import java.util.List;

public interface QueryManager {

    String getQuery(String key);

    <T> List<T> select(String sql, RowMapper<T> rowMapper, Object... parameters) throws SQLException;

    long insertAndGetId(final String sql, final Object... parameters) throws SQLException;

    int update(final String sql, final Object... parameters) throws SQLException;

}