package com.venepiano.repository.core.handler;

import com.venepiano.domain.member.Gender;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderTypeHandler extends BaseTypeHandler<Gender> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Gender parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToGender(value);
    }

    @Override
    public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToGender(value);
    }

    @Override
    public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToGender(value);
    }

    private Gender convertToGender(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Gender.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}