package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.CartDto;
import ru.itis.demo.services.CartService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{cart-id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("cart-id") Long cartId) {
        return ResponseEntity.ok(cartService.getCartById(cartId));
    }

    @GetMapping("/account/{account-id}")
    public ResponseEntity<CartDto> getCartByAccountId(@PathVariable("account-id") Long accountId) {
        return ResponseEntity.ok(cartService.getCartByAccountId(accountId));
    }

    @GetMapping("/{cart-id}/product/{product-id}")
    public ResponseEntity<CartDto> addProduct(@PathVariable("cart-id") Long cartId, @PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(cartService.addProduct(cartId, productId));
    }

    @DeleteMapping("/{cart-id}/product/{product-id}")
    public ResponseEntity<CartDto> removeProduct(@PathVariable("cart-id") Long cartId, @PathVariable("product-id") Long productId) {
        cartService.deleteProduct(cartId, productId);
        return ResponseEntity.ok().build();
    }
}
