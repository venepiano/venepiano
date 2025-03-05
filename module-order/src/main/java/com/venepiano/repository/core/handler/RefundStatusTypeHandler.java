package com.venepiano.repository.core.handler;

import com.venepiano.domain.refund.RefundStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RefundStatusTypeHandler extends BaseTypeHandler<RefundStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, RefundStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public RefundStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToMemberStatus(value);
    }

    @Override
    public RefundStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    @Override
    public RefundStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    private RefundStatus convertToMemberStatus(String value) {
        if (value == null) {
            return null;
        }
        try {
            return RefundStatus.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}