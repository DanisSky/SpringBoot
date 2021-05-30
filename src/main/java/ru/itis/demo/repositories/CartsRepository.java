package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Cart;
import ru.itis.demo.models.Product;

public interface CartsRepository extends JpaRepository<Cart, Long> {
    Cart findByAccountId(Long accountId);
}
