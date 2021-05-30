package ru.itis.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.demo.models.Category;
import ru.itis.demo.models.Product;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Queue;


public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByIsDeletedIsNull();

    @Query("select product from Product product where " +
            "(:q = 'empty' or UPPER(product.name) like UPPER(concat('%', :q, '%')))")
    Page<Product> search(@Param("q") String q, Pageable pageable);

    List<Product> findByCategory(Category category);

    @Query(value = "select product.id, created, description, is_deleted, name, picture_url, price, updated, category_id from product join product_cart pc on product.id = pc.product_id  where cart_id =(select cart_id from cart where account_id=:id)", nativeQuery = true)
    List<Product> getAllByAccountId(@Param("id") Long accountId);
}
