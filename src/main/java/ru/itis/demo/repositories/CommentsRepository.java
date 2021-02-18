package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByCarId(Long id);
}
