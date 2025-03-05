package com.venepiano.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMean { // 결제 수단

    private String meanId;
    private String meanName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
