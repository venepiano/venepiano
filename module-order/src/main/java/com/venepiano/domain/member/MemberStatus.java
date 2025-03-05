package com.venepiano.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberStatus {

    A("재직"),
    B("휴직"),
    C("퇴사");

    private final String description;

}
