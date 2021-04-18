package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Cart;

public interface CartsRepository extends JpaRepository<Cart, Long> {
    Cart findByAccountId(Long accountId);
}
