package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Product;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByIsDeletedIsNull();
}