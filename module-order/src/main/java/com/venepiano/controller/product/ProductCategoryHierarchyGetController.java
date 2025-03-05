package com.venepiano.controller.product;

import com.venepiano.controller.product.response.ProductCategoryHierarchyResponseBody;
import com.venepiano.controller.responsebody.GeneralResponseBody;
import com.venepiano.service.product.ProductCategoryHierarchyQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCategoryHierarchyGetController {

    private final ProductCategoryHierarchyQueryService productCategoryHierarchyQueryService;

    @GetMapping("/api/v1/product-categories/hierarchy")
    public ResponseEntity<GeneralResponseBody<List<ProductCategoryHierarchyResponseBody>>> getCategoriesHierarchy() {
        List<ProductCategoryHierarchyResponseBody> result = productCategoryHierarchyQueryService.getCategoriesHierarchy()
                .stream()
                .map(ProductCategoryHierarchyResponseBody::from)
                .toList();

        return new ResponseEntity<>(GeneralResponseBody.from(result), HttpStatus.OK);
    }

}
