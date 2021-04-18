package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.Cart;
import ru.itis.demo.models.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {
    private Long id;

    private List<Long> products;

    public static CartDto from(Cart cart) {
        CartDto result = CartDto.builder()
                .id(cart.getId())
                .build();

        if (cart.getProductList() != null) {
            result.setProducts(cart.getProductList().stream().map(Product::getId).collect(Collectors.toList()));
        }
        return result;
    }

    public static List<CartDto> from(List<Cart> carts) {
        return carts.stream().map(CartDto::from).collect(Collectors.toList());
    }
}
