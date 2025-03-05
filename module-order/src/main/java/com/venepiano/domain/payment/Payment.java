package com.venepiano.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment { // 결제
    
    private String paymentId;
    private String orderId;
    private LocalDateTime paymentDate;
    private BigDecimal paymentAmount;
    private String sttlNo;
    private String meanDtlId;
    private PaymentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
