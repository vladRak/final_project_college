package com.final_project_college.dao.jdbc;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DefaultPreparedStatementParameterSetter implements PreparedStatementParameterSetter {

    @Override
    public void setParameters(final PreparedStatement statement, final Object... parameters) throws SQLException {
        for (int i = 0, length = parameters.length; i < length; i++) {
            final Object parameter = parameters[i];
            final int parameterIndex = i + 1;
            if (null == parameter) {
                statement.setObject(parameterIndex, null);
            } else if (parameter instanceof Boolean) {
                statement.setBoolean(parameterIndex, (Boolean) parameter);
            } else if (parameter instanceof Character) {
                statement.setString(parameterIndex, String.valueOf(parameter));
            } else if (parameter instanceof Byte) {
                statement.setByte(parameterIndex, (Byte) parameter);
            } else if (parameter instanceof Short) {
                statement.setShort(parameterIndex, (Short) parameter);
            } else if (parameter instanceof Integer) {
                statement.setInt(parameterIndex, (Integer) parameter);
            } else if (parameter instanceof Long) {
                statement.setLong(parameterIndex, (Long) parameter);
            } else if (parameter instanceof Float) {
                statement.setFloat(parameterIndex, (Float) parameter);
            } else if (parameter instanceof Double) {
                statement.setDouble(parameterIndex, (Double) parameter);
            } else if (parameter instanceof String) {
                statement.setString(parameterIndex, (String) parameter);
            } else if (parameter instanceof Timestamp) {
                statement.setTimestamp(parameterIndex, (Timestamp) parameter);
            } else if (parameter instanceof Date) {
                statement.setDate(parameterIndex, new java.sql.Date(((Date) parameter).getTime()));
            } else if (parameter instanceof Calendar) {
                statement.setDate(parameterIndex, new java.sql.Date(((Calendar) parameter).getTimeInMillis()));
            } else if (parameter instanceof BigDecimal) {
                statement.setBigDecimal(parameterIndex, (BigDecimal) parameter);
            } else if (parameter instanceof byte[]) {
                statement.setBytes(parameterIndex, (byte[]) parameter);
            } else {
                throw new IllegalArgumentException(String.format(
                        "Unknown type of the parameter is found. [param: %s, paramIndex: %s]", parameter, parameterIndex));
            }
        }
    }
}