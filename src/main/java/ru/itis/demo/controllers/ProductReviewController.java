package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.ProductReviewDto;
import ru.itis.demo.services.ProductReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("/product/{product-id}")
    public ResponseEntity<List<ProductReviewDto>> getAllReviewsByProductId(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(productReviewService.getAllByProductId(productId));
    }

    @GetMapping("/account/{account-id}")
    public ResponseEntity<List<ProductReviewDto>> getAllReviewsByAccountId(@PathVariable("account-id") Long accountId) {
        return ResponseEntity.ok(productReviewService.getAllByAccountId(accountId));
    }

    @PutMapping("/{review-id}")
    public ResponseEntity<ProductReviewDto> updateReview(@PathVariable("review-id") Long reviewId, @RequestBody ProductReviewDto review) {
        return ResponseEntity.ok(productReviewService.updateProductReview(reviewId, review));
    }

    @DeleteMapping("/{review-id}")
    public ResponseEntity<?> deleteReview(@PathVariable("review-id") Long reviewId) {
        productReviewService.deleteReview(reviewId);
        return ResponseEntity.ok().build();
    }
}
