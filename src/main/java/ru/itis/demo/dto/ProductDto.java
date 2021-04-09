package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.ProductReview;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Date created;
    private Date updated;
    private String pictureUrl;
    private String category;

    private List<String> productReviews;

    public static ProductDto from(Product product) {
        ProductDto result = ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .created(product.getCreated())
                .updated(product.getUpdated())
                .pictureUrl(product.getPictureUrl())
                .category(product.getCategory().getName())
                .build();

        if (product.getProductReviews() != null) {
            result.setProductReviews(product.getProductReviews().stream().map(ProductReview::getText).collect(Collectors.toList()));
        }
        return result;
    }

    public static List<ProductDto> from(List<Product> products) {
        return products.stream().map(ProductDto::from).collect(Collectors.toList());
    }
}
