package com.venepiano.repository.core.handler;

import com.venepiano.domain.point.PointType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointTypeTypeHandler extends BaseTypeHandler<PointType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, PointType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public PointType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToMemberStatus(value);
    }

    @Override
    public PointType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    @Override
    public PointType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    private PointType convertToMemberStatus(String value) {
        if (value == null) {
            return null;
        }
        try {
            return PointType.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}