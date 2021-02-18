package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.Comment;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private String text;
    private String data;
    private UserDto userDto;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .data(comment.getData())
                .text(comment.getText())
                .build();
    }

    public static List<CommentDto> from(List<Comment> comments) {
        return comments.stream().map(CommentDto::from).collect(Collectors.toList());
    }
}
