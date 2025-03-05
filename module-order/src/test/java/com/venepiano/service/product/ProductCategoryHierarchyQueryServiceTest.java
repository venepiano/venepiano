package com.venepiano.service.product;

import com.venepiano.domain.product.ProductCategoryHierarchy;
import com.venepiano.domain.product.ProductCategoryHierarchyNode;
import com.venepiano.repository.facade.product.ProductCategoryHierarchyOueryFacadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductCategoryHierarchyQueryServiceTest {

    @Mock
    private ProductCategoryHierarchyOueryFacadeRepository repository;

    @InjectMocks
    private ProductCategoryHierarchyQueryService service;

    private List<ProductCategoryHierarchy> mockCategories;

    @BeforeEach
    void setUp() {
        // 테스트 데이터 설정
        mockCategories = new ArrayList<>();

        // 가전제품 카테고리와 하위 카테고리
        mockCategories.add(new ProductCategoryHierarchy("가전제품", "CAT002", null, 1L));
        mockCategories.add(new ProductCategoryHierarchy("TV", "CAT007", "CAT002", 2L));
        mockCategories.add(new ProductCategoryHierarchy("냉장고", "CAT008", "CAT002", 2L));
        mockCategories.add(new ProductCategoryHierarchy("세탁기", "CAT009", "CAT002", 2L));

        // 사무용품 카테고리와 하위 카테고리
        mockCategories.add(new ProductCategoryHierarchy("사무용품", "CAT003", null, 1L));
        mockCategories.add(new ProductCategoryHierarchy("문구류", "CAT012", "CAT003", 2L));
        mockCategories.add(new ProductCategoryHierarchy("사무용 가구", "CAT010", "CAT003", 2L));
        mockCategories.add(new ProductCategoryHierarchy("사무용 기기", "CAT011", "CAT003", 2L));

        // 전자기기 카테고리와 하위 카테고리
        mockCategories.add(new ProductCategoryHierarchy("전자기기", "CAT001", null, 1L));
        mockCategories.add(new ProductCategoryHierarchy("노트북", "CAT005", "CAT001", 2L));
        mockCategories.add(new ProductCategoryHierarchy("스마트폰", "CAT004", "CAT001", 2L));
        mockCategories.add(new ProductCategoryHierarchy("태블릿", "CAT006", "CAT001", 2L));
    }

    @Test
    @DisplayName("카테고리 계층 구조를 올바르게 구성한다")
    void getCategoriesHierarchy_ShouldReturnCorrectHierarchy() {
        // given
        when(repository.findHierarchyCategories()).thenReturn(mockCategories);

        // when
        List<ProductCategoryHierarchyNode> result = service.getCategoriesHierarchy();

        // then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(3); // 최상위 카테고리 3개

        // 각 루트 카테고리 및 하위 카테고리 확인

        // 가전제품 카테고리 확인
        ProductCategoryHierarchyNode electronics = findNodeById(result, "CAT002");
        assertThat(electronics).isNotNull();
        assertThat(electronics.getRootCategories().getHierarchy()).isEqualTo("가전제품");
        assertThat(electronics.getSubCategories()).hasSize(3);

        // TV 하위 카테고리 확인
        assertThat(findSubcategoryById(electronics, "CAT007")).isNotNull();
        assertThat(findSubcategoryById(electronics, "CAT007").getRootCategories().getHierarchy()).isEqualTo("TV");

        // 냉장고 하위 카테고리 확인
        assertThat(findSubcategoryById(electronics, "CAT008")).isNotNull();
        assertThat(findSubcategoryById(electronics, "CAT008").getRootCategories().getHierarchy()).isEqualTo("냉장고");

        // 세탁기 하위 카테고리 확인
        assertThat(findSubcategoryById(electronics, "CAT009")).isNotNull();
        assertThat(findSubcategoryById(electronics, "CAT009").getRootCategories().getHierarchy()).isEqualTo("세탁기");

        // 사무용품 카테고리 확인
        ProductCategoryHierarchyNode officeSupplies = findNodeById(result, "CAT003");
        assertThat(officeSupplies).isNotNull();
        assertThat(officeSupplies.getRootCategories().getHierarchy()).isEqualTo("사무용품");
        assertThat(officeSupplies.getSubCategories()).hasSize(3);

        // 문구류 하위 카테고리 확인
        assertThat(findSubcategoryById(officeSupplies, "CAT012")).isNotNull();
        assertThat(findSubcategoryById(officeSupplies, "CAT012").getRootCategories().getHierarchy()).isEqualTo("문구류");

        // 전자기기 카테고리 확인
        ProductCategoryHierarchyNode digitalDevices = findNodeById(result, "CAT001");
        assertThat(digitalDevices).isNotNull();
        assertThat(digitalDevices.getRootCategories().getHierarchy()).isEqualTo("전자기기");
        assertThat(digitalDevices.getSubCategories()).hasSize(3);

        // 하위 카테고리들에 자식이 없는지 확인
        for (ProductCategoryHierarchyNode rootNode : result) {
            for (ProductCategoryHierarchyNode childNode : rootNode.getSubCategories()) {
                assertThat(childNode.getSubCategories()).isEmpty();
            }
        }
    }

    @Test
    @DisplayName("빈 카테고리 목록이 주어지면 빈 결과를 반환한다")
    void getCategoriesHierarchy_WithEmptyList_ShouldReturnEmptyList() {
        // given
        when(repository.findHierarchyCategories()).thenReturn(List.of());

        // when
        List<ProductCategoryHierarchyNode> result = service.getCategoriesHierarchy();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("null 카테고리 목록이 주어지면 빈 결과를 반환한다")
    void getCategoriesHierarchy_WithNullList_ShouldReturnEmptyList() {
        // given
        when(repository.findHierarchyCategories()).thenReturn(null);

        // when
        List<ProductCategoryHierarchyNode> result = service.getCategoriesHierarchy();

        // then
        assertThat(result).isEmpty();
    }

    // 헬퍼 메서드: 주어진 ID로 노드 찾기
    private ProductCategoryHierarchyNode findNodeById(List<ProductCategoryHierarchyNode> nodes, String categoryId) {
        return nodes.stream()
                .filter(node -> node.getRootCategories().getCategoryId().equals(categoryId))
                .findFirst()
                .orElse(null);
    }

    // 헬퍼 메서드: 주어진 노드 내에서 ID로 하위 카테고리 찾기
    private ProductCategoryHierarchyNode findSubcategoryById(ProductCategoryHierarchyNode parent, String categoryId) {
        return parent.getSubCategories().stream()
                .filter(node -> node.getRootCategories().getCategoryId().equals(categoryId))
                .findFirst()
                .orElse(null);
    }

}