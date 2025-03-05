package com.venepiano.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail { // 주문 상세

    private String orderDetailId;
    private String orderId;
    private String productId;
    private Long quantity;
    private BigDecimal unitPrice;
    private BigDecimal discountAmount;
    private BigDecimal lineAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
