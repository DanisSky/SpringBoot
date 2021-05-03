package ru.itis.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.demo.models.Category;
import ru.itis.demo.models.Product;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByIsDeletedIsNull();
    @Query("select product from Product product where " +
            "(:q = 'empty' or UPPER(product.name) like UPPER(concat('%', :q, '%')))")
    Page<Product> search(@Param("q") String q, Pageable pageable);

    List<Product> findByCategory(Category category);
}
