package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.CommentDto;
import ru.itis.demo.models.Comment;
import ru.itis.demo.repositories.CommentsRepository;

import java.util.List;

@Component
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public void addComment(Comment comment) {
        commentsRepository.save(comment);
    }

    @Override
    public List<CommentDto> getAllCommentsByCarId(Long id) {
        return CommentDto.from(commentsRepository.findAllByCarId(id));
    }
}
