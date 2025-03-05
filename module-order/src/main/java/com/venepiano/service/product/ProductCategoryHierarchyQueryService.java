package com.venepiano.service.product;

import com.venepiano.domain.product.ProductCategoryHierarchy;
import com.venepiano.domain.product.ProductCategoryHierarchyNode;
import com.venepiano.repository.facade.product.ProductCategoryHierarchyOueryFacadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryHierarchyQueryService {

    private final ProductCategoryHierarchyOueryFacadeRepository repository;

    public List<ProductCategoryHierarchyNode> getCategoriesHierarchy() {
        List<ProductCategoryHierarchy> allCategories = repository.findHierarchyCategories();

        if (allCategories == null || allCategories.isEmpty()) return Collections.emptyList();

        return allCategories.stream()
                .filter(category -> category.getDepth() == 1)
                .map(rootCategory -> buildRecursiveTree(rootCategory, allCategories))
                .toList();
    }

    private ProductCategoryHierarchyNode buildRecursiveTree(
            ProductCategoryHierarchy current,
            List<ProductCategoryHierarchy> allCategories
    ) {
        List<ProductCategoryHierarchyNode> childNodes = allCategories.stream()
                .filter(category -> current.getCategoryId().equals(category.getParentCategoryId()))
                .map(childCategory -> buildRecursiveTree(childCategory, allCategories))
                .toList();

        return new ProductCategoryHierarchyNode(current, childNodes);
    }

}
