package com.venepiano.repository.facade.product;

import com.venepiano.domain.product.ProductCategoryHierarchy;
import com.venepiano.repository.mapper.product.ProductCategoryHierarchyQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductCategoryHierarchyOueryFacadeRepository {

    private final ProductCategoryHierarchyQueryMapper mapper;

    @Transactional(readOnly = true)
    public List<ProductCategoryHierarchy> findHierarchyCategories() {
        return mapper.findHierarchyCategories();
    }

}
