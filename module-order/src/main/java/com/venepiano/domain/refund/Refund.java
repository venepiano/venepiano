package com.venepiano.domain.refund;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Refund { // 환불

    private String refundId;
    private String paymentId;
    private LocalDateTime refundDate;
    private BigDecimal refundAmount;
    private String refundReason;
    private RefundStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
