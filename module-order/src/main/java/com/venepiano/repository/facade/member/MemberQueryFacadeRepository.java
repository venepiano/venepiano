package com.venepiano.repository.facade.member;

import com.venepiano.domain.member.Member;
import com.venepiano.repository.mapper.member.MemberQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryFacadeRepository {

    private final MemberQueryMapper memberQueryMapper;

    @Transactional(readOnly = true)
    public List<Member> findMembersByTeamId(String teamId) {
        return memberQueryMapper.findByTeam(teamId);
    }

}
