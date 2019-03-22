package com.final_project_college.dao.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface QueryManager {

    String getQuery(String key);

    <T> List<T> select(final String sql, final RowMapper<T> rowMapper, final Object... parameters) throws SQLException;

    long insertAndGetId(final String sql, final Object... parameters) throws SQLException;

    int update(final String sql, final Object... parameters) throws SQLException;

}