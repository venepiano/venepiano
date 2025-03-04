package com.venepiano.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
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
}
