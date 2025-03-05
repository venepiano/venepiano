package com.venepiano.domain.refund;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RefundStatus {

    PENDING("환불 요청 대기"),
    PROCESSING("환불 처리 중"),
    COMPLETED("환불 완료"),
    REJECTED("환불 거부"),
    CANCELLED("환불 요청 취소");

    private final String description;

}
