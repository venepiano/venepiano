package com.venepiano.service.member;

import com.venepiano.domain.member.Member;
import com.venepiano.repository.facade.member.MemberQueryFacadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberQueryFacadeRepository memberQueryFacadeRepository;

    public List<Member> findMembersByTeamId(String teamId) {
        if (teamId == null || teamId.trim().isEmpty()) return Collections.emptyList();
        return memberQueryFacadeRepository.findMembersByTeamId(teamId);
    }
}
