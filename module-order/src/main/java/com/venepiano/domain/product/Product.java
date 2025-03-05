package com.venepiano.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product { // 상품
    
    private String productId;
    private String productName;
    private String categoryId;
    private BigDecimal price;
    private BigDecimal discountRate;
    private Long stockQuantity;
    private String description;
    private ProductStatus status;
    private String projectId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
