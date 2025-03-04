package com.venepiano.controller.member.body;

import com.venepiano.domain.member.Gender;
import com.venepiano.domain.member.Member;
import com.venepiano.domain.member.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseBody {
    private String mbrId;
    private String custCoCd;
    private String name;
    private String email;
    private String phone;
    private String birthDate;
    private Gender gender;
    private LocalDate joinDate;
    private MemberStatus status;
    private String teamId;
    private String deptId;
    private String divId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MemberResponseBody from(Member member) {
        return MemberResponseBody.builder()
                .mbrId(member.getMbrId())
                .custCoCd(member.getCustCoCd())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .birthDate(member.getBirthDate())
                .gender(member.getGender())
                .joinDate(member.getJoinDate())
                .status(member.getStatus())
                .teamId(member.getTeamId())
                .deptId(member.getDeptId())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .build();
    }
}
