package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.CategoryDto;
import ru.itis.demo.dto.ProductDto;
import ru.itis.demo.dto.ProductsPage;
import ru.itis.demo.services.CategoryService;
import ru.itis.demo.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/search")
    public ResponseEntity<ProductsPage> search(@RequestParam("size") Integer size,
                                               @RequestParam("page") Integer page,
                                               @RequestParam(value = "q", required = false) String query,
                                               @RequestParam(value = "sort", required = false) String sort,
                                               @RequestParam(value = "direction", required = false) String direction) {
        return ResponseEntity.ok(productService.search(size, page, query, sort, direction));
    }

    @GetMapping("/")
    public String getAllProducts(@RequestParam(value = "id", required = false) String categoryId, Model model) {
        CategoryDto category = null;
        if (categoryId != null) {
            category = categoryService.getCategoryById(Long.valueOf(categoryId));
            model.addAttribute("products", productService.getAllProductsByCategory(Long.valueOf(categoryId)));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("category", category);
        return "root_page";
    }

    @GetMapping("/{product-id}")
    @ResponseBody
    public ResponseEntity<ProductDto> getProductById(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

}
