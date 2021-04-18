package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.CartDto;
import ru.itis.demo.models.Cart;
import ru.itis.demo.models.Product;
import ru.itis.demo.repositories.CartsRepository;
import ru.itis.demo.repositories.ProductsRepository;

import java.util.List;

import static ru.itis.demo.dto.CartDto.from;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public CartDto getCartById(Long id) {
        return from(cartsRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public CartDto getCartByAccountId(Long id) {
        return from(cartsRepository.findByAccountId(id));
    }

    @Override
    public CartDto addProduct(Long id, Long productId) {
        Cart cart = cartsRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Product productForCart = productsRepository.findById(productId).orElseThrow(IllegalArgumentException::new);

        productForCart.getCarts().add(cart);
        productsRepository.save(productForCart);
        return from(cart);
    }

    @Override
    public void deleteProduct(Long cartId, Long productId) {
        Cart cart = cartsRepository.findById(cartId).orElseThrow(IllegalArgumentException::new);
        Product productForDelete = productsRepository.findById(productId).orElseThrow(IllegalArgumentException::new);

        productForDelete.getCarts().remove(cart);
        productsRepository.save(productForDelete);
    }
}
