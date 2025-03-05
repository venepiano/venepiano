package com.venepiano.repository.core.handler;

import com.venepiano.domain.payment.BankCode;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankCodeTypeHandler extends BaseTypeHandler<BankCode> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BankCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public BankCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToBankCode(value);
    }

    @Override
    public BankCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToBankCode(value);
    }

    @Override
    public BankCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToBankCode(value);
    }

    private BankCode convertToBankCode(String value) {
        if (value == null) {
            return null;
        }

        try {
            return BankCode.fromCode(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
