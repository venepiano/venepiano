package com.venepiano.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCash { // 현금 결제
    
    private String sttlNo;
    private String paymentId;
    private String bankCode;
    private String accountNo;
    private String accountHolder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
