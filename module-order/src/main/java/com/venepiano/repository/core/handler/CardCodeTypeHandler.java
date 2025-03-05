package com.venepiano.repository.core.handler;

import com.venepiano.domain.payment.CardCode;
import com.venepiano.domain.vendor.VendorStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardCodeTypeHandler extends BaseTypeHandler<CardCode> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CardCode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public CardCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToMemberStatus(value);
    }

    @Override
    public CardCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    @Override
    public CardCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    private CardCode convertToMemberStatus(String value) {
        if (value == null) {
            return null;
        }
        try {
            return CardCode.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}