package com.venepiano.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCard { // 카드 결제
    
    private String sttlNo;
    private String paymentId;
    private String cardType;
    private String cardNo;
    private String cardHolder;
    private String approvalNo;
    private Integer installmentMonths;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}