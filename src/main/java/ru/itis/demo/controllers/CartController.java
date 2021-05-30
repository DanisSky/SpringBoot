package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.AccountDto;
import ru.itis.demo.dto.CartDto;
import ru.itis.demo.dto.ProductDto;
import ru.itis.demo.models.Cart;
import ru.itis.demo.services.AccountsService;
import ru.itis.demo.services.CartService;
import ru.itis.demo.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/")
    public String getCartPage(HttpServletRequest req, Model model) {
        AccountDto account = accountsService.getAccountByEmail(req.getUserPrincipal().getName());
        List<ProductDto> productDtos = productService.getAllProductsByAccountId(account.getId());
        model.addAttribute("products", productDtos);
        Optional<Double> total = productDtos.stream().map(ProductDto::getPrice).reduce(Double::sum);
        model.addAttribute("total", total.orElse(0.0));
        return "cart_page";
    }

    @GetMapping("/{cart-id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("cart-id") Long cartId) {
        return ResponseEntity.ok(cartService.getCartById(cartId));
    }

    @GetMapping("/account/{account-id}")
    public ResponseEntity<CartDto> getCartByAccountId(@PathVariable("account-id") Long accountId) {
        return ResponseEntity.ok(cartService.getCartByAccountId(accountId));
    }

    @GetMapping("/product/add/{product-id}")
    public String addProduct(HttpServletRequest req, @PathVariable("product-id") Long productId) {
        AccountDto account = accountsService.getAccountByEmail(req.getUserPrincipal().getName());
        CartDto cart = cartService.getCartByAccountId(account.getId());
        cartService.addProduct(cart.getId(), productId);
        return "redirect:/cart/";
    }

    @GetMapping("/product/remove/{product-id}")
    public String removeProduct(HttpServletRequest req, @PathVariable("product-id") Long productId) {
        AccountDto account = accountsService.getAccountByEmail(req.getUserPrincipal().getName());
        CartDto cart = cartService.getCartByAccountId(account.getId());
        cartService.deleteProduct(cart.getId(), productId);
        return "redirect:/cart/";
    }
}
