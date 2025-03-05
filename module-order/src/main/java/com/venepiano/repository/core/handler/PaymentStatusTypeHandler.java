package com.venepiano.repository.core.handler;

import com.venepiano.domain.payment.PaymentStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentStatusTypeHandler extends BaseTypeHandler<PaymentStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, PaymentStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public PaymentStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToMemberStatus(value);
    }

    @Override
    public PaymentStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    @Override
    public PaymentStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    private PaymentStatus convertToMemberStatus(String value) {
        if (value == null) {
            return null;
        }
        try {
            return PaymentStatus.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}