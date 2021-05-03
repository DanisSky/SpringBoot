package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.ProductReview;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductReviewDto {
    private Long id;
    private String text;
    private Integer stars;
    private Date added;
    private Long productId;

    private String accountEmail;

    public static ProductReviewDto from(ProductReview productReview) {
        ProductReviewDto result = ProductReviewDto.builder()
                .id(productReview.getId())
                .accountEmail(productReview.getAccount().getEmail())
                .text(productReview.getText())
                .stars(productReview.getStars())
                .added(productReview.getAdded())
                .productId(productReview.getProduct().getId())
                .build();

        return result;
    }

    public static List<ProductReviewDto> from(List<ProductReview> productReviews) {
        return productReviews.stream().map(ProductReviewDto::from).collect(Collectors.toList());
    }
}
