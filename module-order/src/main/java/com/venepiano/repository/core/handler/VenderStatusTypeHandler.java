package com.venepiano.repository.core.handler;

import com.venepiano.domain.vendor.VendorStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VenderStatusTypeHandler extends BaseTypeHandler<VendorStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, VendorStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public VendorStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToMemberStatus(value);
    }

    @Override
    public VendorStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    @Override
    public VendorStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    private VendorStatus convertToMemberStatus(String value) {
        if (value == null) {
            return null;
        }
        try {
            return VendorStatus.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}