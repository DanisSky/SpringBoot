package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Category;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    List<Category> findAllByIsDeletedIsNull();
}
