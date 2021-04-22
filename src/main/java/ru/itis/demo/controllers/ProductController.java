package ru.itis.demo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.ProductDto;
import ru.itis.demo.dto.ProductsPage;
import ru.itis.demo.services.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<ProductsPage> search(@RequestParam("size") Integer size,
                                               @RequestParam("page") Integer page,
                                               @RequestParam(value = "q", required = false) String query,
                                               @RequestParam(value = "sort", required = false) String sort,
                                               @RequestParam(value = "direction", required = false) String direction) {
        return ResponseEntity.ok(productService.search(size, page, query, sort, direction));
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @ApiOperation(value = "Добавление продукта")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = ProductDto.class)})
    @PostMapping("/")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("product-id") Long productId, @RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.updateProduct(productId, product));
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("product-id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
