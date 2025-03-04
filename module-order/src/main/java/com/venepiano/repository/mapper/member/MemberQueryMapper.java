package com.venepiano.repository.mapper.member;

import com.venepiano.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberQueryMapper {

    /**
     * 회원 ID로 회원 조회
     *
     * @param mbrId 회원 ID
     * @return 회원 정보
     */
    Member findById(@Param("mbrId") String mbrId);

    /**
     * 모든 회원 조회
     *
     * @return 회원 목록
     */
    List<Member> findAll();

    /**
     * 팀 ID로 회원 목록 조회
     *
     * @param teamId 팀 ID
     * @return 팀에 속한 회원 목록
     */
    List<Member> findByTeam(@Param("teamId") String teamId);

    /**
     * 부서 ID로 회원 목록 조회
     *
     * @param deptId 부서 ID
     * @return 부서에 속한 회원 목록
     */
    List<Member> findByDepartment(@Param("deptId") String deptId);

    /**
     * 본부 ID로 회원 목록 조회
     *
     * @param divId 본부 ID
     * @return 본부에 속한 회원 목록
     */
    List<Member> findByDivision(@Param("divId") String divId);

    /**
     * 회원 상태로 회원 목록 조회
     *
     * @param status 회원 상태
     * @return 해당 상태의 회원 목록
     */
    List<Member> findByStatus(@Param("status") String status);

    /**
     * 회사 코드로 회원 목록 조회
     *
     * @param custCoCd 회사 코드
     * @return 해당 회사의 회원 목록
     */
    List<Member> findByCompany(@Param("custCoCd") String custCoCd);
}
