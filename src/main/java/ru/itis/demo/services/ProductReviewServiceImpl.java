package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.ProductReviewDto;
import ru.itis.demo.models.ProductReview;
import ru.itis.demo.repositories.AccountsRepository;
import ru.itis.demo.repositories.ProductReviewsRepository;
import ru.itis.demo.repositories.ProductsRepository;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import static ru.itis.demo.dto.ProductReviewDto.from;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    private ProductReviewsRepository productReviewsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public List<ProductReviewDto> getAllByProductId(Long productId) {
        return from(productReviewsRepository.findAllByProductIdAndIsDeletedIsNull(productId));
    }

    @Override
    public List<ProductReviewDto> getAllByAccountId(Long accountId) {
        return from(productReviewsRepository.findAllByAccountIdAndIsDeletedIsNull(accountId));
    }

    @Override
    public ProductReviewDto updateProductReview(Long productReviewId, ProductReviewDto productReviewDto) {
        ProductReview productReviewForUpdate = productReviewsRepository.findById(productReviewId).orElseThrow(IllegalArgumentException::new);
        productReviewForUpdate.setStars(productReviewDto.getStars());
        productReviewDto.setText(productReviewDto.getText());

        return from(productReviewForUpdate);
    }

    @Override
    public void deleteReview(Long reviewId) {
        ProductReview productReviewForDelete = productReviewsRepository.findById(reviewId).orElseThrow(IllegalArgumentException::new);
        productReviewForDelete.setIsDeleted(true);
        productReviewsRepository.save(productReviewForDelete);
    }

    @Override
    public List<ProductReviewDto> addReview(ProductReviewDto productReviewDto) {
        ProductReview productReview = ProductReview.builder()
                .product(productsRepository.findById(productReviewDto.getProductId()).orElseThrow(IllegalArgumentException::new))
                .stars(productReviewDto.getStars())
                .account(accountsRepository.findByEmail(productReviewDto.getAccountEmail()).orElseThrow(IllegalArgumentException::new))
                .added(new Date(Instant.now().getEpochSecond()))
                .text(productReviewDto.getText())
                .build();

        productReviewsRepository.save(productReview);
        return getAllByProductId(productReview.getProduct().getId());
    }
}
