package com.venepiano.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMeanDtl { // 결제 수단 상세

    private String meanDtlId;
    private String meanId;
    private String dtlName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
