package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.Category;
import ru.itis.demo.models.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String name;

    private List<Long> products;

    public static CategoryDto from(Category category) {
        CategoryDto result = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();

        if (category.getProducts() != null) {
            result.setProducts(category.getProducts().stream().map(Product::getId).collect(Collectors.toList()));
        }
        return result;
    }

    public static List<CategoryDto> from(List<Category> categories) {
        return categories.stream().map(CategoryDto::from).collect(Collectors.toList());
    }
}
