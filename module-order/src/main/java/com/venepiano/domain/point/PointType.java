package com.venepiano.domain.point;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PointType {

    EARN("포인트 적립"),
    USE("포인트 사용"),
    REFUND("포인트 반환");

    private final String description;

}