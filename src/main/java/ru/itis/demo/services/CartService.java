package ru.itis.demo.services;

import ru.itis.demo.dto.CartDto;

public interface CartService {
    CartDto getCartById(Long id);

    CartDto getCartByAccountId(Long id);

    CartDto addProduct(Long id, Long productId);

    void deleteProduct(Long cartId, Long productId);
}
