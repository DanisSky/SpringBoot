package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.ProductReview;

import java.util.List;

public interface ProductReviewsRepository extends JpaRepository<ProductReview, Long> {
    List<ProductReview> findAllByProductIdAndIsDeletedIsNull(Long productId);
    List<ProductReview> findAllByAccountIdAndIsDeletedIsNull(Long accountId);
}
