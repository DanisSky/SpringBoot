package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.CategoryDto;
import ru.itis.demo.models.Category;
import ru.itis.demo.repositories.CategoriesRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.demo.dto.CategoryDto.from;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return from(categoriesRepository.findAllByIsDeletedIsNull().stream().filter(category -> category.getProducts().size() != 0).collect(Collectors.toList()));
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category newCategory = Category.builder()
                .name(categoryDto.getName())
                .build();

        categoriesRepository.save(newCategory);

        return from(newCategory);
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category categoryForUpdate = categoriesRepository.findById(categoryId).orElseThrow(IllegalArgumentException::new);
        categoryForUpdate.setName(categoryDto.getName());

        return from(categoryForUpdate);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category categoryForDelete = categoriesRepository.findById(categoryId).orElseThrow(IllegalArgumentException::new);
        categoryForDelete.setIsDeleted(true);
        categoriesRepository.save(categoryForDelete);
    }
}
