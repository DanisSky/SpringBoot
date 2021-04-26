package ru.itis.demo.services;

import ru.itis.demo.dto.ProductDto;
import ru.itis.demo.dto.ProductsPage;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductsPage search(Integer size, Integer page, String query, String sort, String direction);

    ProductDto getProductById(Long id);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(Long productId, ProductDto productDto);

    void deleteProduct(Long productId);

    List<ProductDto> getAllProductsByCategory(Long id);
}
