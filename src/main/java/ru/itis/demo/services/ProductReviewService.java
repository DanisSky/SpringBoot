package ru.itis.demo.services;

import ru.itis.demo.dto.ProductReviewDto;

import java.util.List;

public interface ProductReviewService {
    List<ProductReviewDto> getAllByProductId(Long productId);

    List<ProductReviewDto> getAllByAccountId(Long accountId);

    ProductReviewDto updateProductReview(Long productReviewId, ProductReviewDto productReviewDto);

    void deleteReview(Long reviewId);

    List<ProductReviewDto> addReview(ProductReviewDto productReviewDto);
}
