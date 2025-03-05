package com.venepiano.repository.mapper.product;

import com.venepiano.domain.product.ProductCategoryHierarchy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryHierarchyQueryMapper {

    List<ProductCategoryHierarchy> findHierarchyCategories();

}
