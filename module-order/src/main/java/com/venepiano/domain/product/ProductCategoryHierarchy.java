package com.venepiano.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryHierarchy {

    private String hierarchy;
    private String categoryId;
    private String parentCategoryId;
    private Long depth;

}
