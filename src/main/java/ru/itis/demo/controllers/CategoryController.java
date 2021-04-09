package ru.itis.demo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.dto.CategoryDto;
import ru.itis.demo.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @ApiOperation(value = "Добавление категории")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = CategoryDto.class)})
    @PostMapping("/")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("category-id") Long categoryId, @RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, category));
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("category-id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
