package com.venepiano.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderMaster { // 주문

    private String orderId;
    private String mbrId;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private BigDecimal discountAmount;
    private BigDecimal shippingFee;
    private BigDecimal finalAmount;
    private OrderStatus status;
    private String shippingAddress;
    private String shippingContact;
    private String deliveryRequest;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
