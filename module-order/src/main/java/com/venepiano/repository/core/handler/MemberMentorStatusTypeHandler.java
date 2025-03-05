package com.venepiano.repository.core.handler;

import com.venepiano.domain.member.MemberMentorStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMentorStatusTypeHandler extends BaseTypeHandler<MemberMentorStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, MemberMentorStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public MemberMentorStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return convertToMemberStatus(value);
    }

    @Override
    public MemberMentorStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    @Override
    public MemberMentorStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return convertToMemberStatus(value);
    }

    private MemberMentorStatus convertToMemberStatus(String value) {
        if (value == null) {
            return null;
        }
        try {
            return MemberMentorStatus.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}