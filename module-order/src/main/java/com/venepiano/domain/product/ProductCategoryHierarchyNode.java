package com.venepiano.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryHierarchyNode {

    private ProductCategoryHierarchy rootCategories;
    private List<ProductCategoryHierarchyNode> subCategories;

}
