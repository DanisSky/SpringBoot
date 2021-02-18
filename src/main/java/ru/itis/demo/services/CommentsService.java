package ru.itis.demo.services;

import ru.itis.demo.dto.CommentDto;
import ru.itis.demo.models.Comment;

import java.util.List;

public interface CommentsService {
    List<Comment> getAllComments();
    void addComment(Comment comment);
    List<CommentDto> getAllCommentsByCarId(Long id);
}
