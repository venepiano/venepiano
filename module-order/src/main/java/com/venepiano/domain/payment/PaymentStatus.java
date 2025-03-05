package com.venepiano.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {

    PENDING("결제 대기"),
    COMPLETED("결제 성공"),
    FAILED("결제 실패"),
    REQUESTED("환불 요청"),
    REFUNDED("환불 완료"),
    CANCELLED("결제 취소");

    private final String description;

}
