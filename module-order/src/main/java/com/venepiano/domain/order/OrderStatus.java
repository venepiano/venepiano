package com.venepiano.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    PENDING("주문 접수"),
    SHIPPED("배송 중"),
    COMPLETED("배송 완료"),
    CANCELLED("주문 취소");

    private final String description;

}
