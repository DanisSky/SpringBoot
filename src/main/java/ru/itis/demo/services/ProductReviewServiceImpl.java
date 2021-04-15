package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.ProductReviewDto;
import ru.itis.demo.models.ProductReview;
import ru.itis.demo.repositories.ProductReviewRepository;

import java.util.List;

import static ru.itis.demo.dto.ProductReviewDto.from;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Override
    public List<ProductReviewDto> getAllByProductId(Long productId) {
        return from(productReviewRepository.findAllByProductIdAndIsDeletedIsNull(productId));
    }

    @Override
    public List<ProductReviewDto> getAllByAccountId(Long accountId) {
        return from(productReviewRepository.findAllByAccountIdAndIsDeletedIsNull(accountId));
    }

    @Override
    public ProductReviewDto updateProductReview(Long productReviewId, ProductReviewDto productReviewDto) {
        ProductReview productReviewForUpdate = productReviewRepository.findById(productReviewId).orElseThrow(IllegalArgumentException::new);
        productReviewForUpdate.setStars(productReviewDto.getStars());
        productReviewDto.setText(productReviewDto.getText());

        return from(productReviewForUpdate);
    }

    @Override
    public void deleteReview(Long reviewId) {
        ProductReview productReviewForDelete = productReviewRepository.findById(reviewId).orElseThrow(IllegalArgumentException::new);
        productReviewForDelete.setIsDeleted(true);
        productReviewRepository.save(productReviewForDelete);
    }
}
