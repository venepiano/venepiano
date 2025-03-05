package com.venepiano.controller.product.response;

import com.venepiano.domain.product.ProductCategoryHierarchy;
import com.venepiano.domain.product.ProductCategoryHierarchyNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryHierarchyResponseBody {

    private ProductCategoryField category;
    private List<ProductCategoryHierarchyResponseBody> subCategories;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductCategoryField {
        private String hierarchy;
        private String categoryId;
        private String parentCategoryId;
        private Long depth;

        public static ProductCategoryField from(ProductCategoryHierarchy productCategoryHierarchy) {
            if (productCategoryHierarchy == null) return null;

            return ProductCategoryField.builder()
                    .hierarchy(productCategoryHierarchy.getHierarchy())
                    .categoryId(productCategoryHierarchy.getCategoryId())
                    .parentCategoryId(productCategoryHierarchy.getParentCategoryId())
                    .depth(productCategoryHierarchy.getDepth())
                    .build();
        }
    }

    public static ProductCategoryHierarchyResponseBody from(ProductCategoryHierarchyNode node) {
        if (node == null) return null;
        List<ProductCategoryHierarchyResponseBody> convertedSubCategories = node.getSubCategories().stream()
                .map(ProductCategoryHierarchyResponseBody::from)
                .toList();

        return ProductCategoryHierarchyResponseBody.builder()
                .category(ProductCategoryField.from(node.getRootCategories()))
                .subCategories(convertedSubCategories)
                .build();
    }

}
