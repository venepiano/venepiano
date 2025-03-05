package com.venepiano.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory { // 상품 카테고리
    
    private String categoryId;
    private String categoryName;
    private String parentCategoryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
