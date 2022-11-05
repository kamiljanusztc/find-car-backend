package com.app.findcarbackend.services;



import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.domain.Comment;
import com.app.findcarbackend.repositories.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    CommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    @Test
    public void shouldGetCommentById() {
        //Given
        Comment comment = new Comment(1L, "Joe Doe", "I am super excited! Professional company!");

        when(commentService.getCommentById(1L)).thenReturn(Optional.of(comment));

        Optional<Comment> carModel = commentService.getCommentById(1L);

        //Then
        Assertions.assertEquals(carModel.get().getUserName(), comment.getUserName());
    }

    @Test
    public void shouldGetAllComment() {
        //Given
        List<Comment> commentList = List.of(new Comment(1L, "Joe Doe", "I am super excited! Professional company!"));

        //When
        when(commentService.getAllComments()).thenReturn(commentList);

        //Then
        Assertions.assertNotNull(commentService
                .getAllComments());
        Assertions.assertEquals(1, commentService
                .getAllComments().size());
    }

    @Test
    public void shouldAddComment() {
        //Given
        Comment comment = new Comment(1L, "Joe Doe", "I am super excited! Professional company!");

        when(commentService
                .addComment(comment)).thenReturn(comment);

        List<Comment> carList = new ArrayList<>();
        carList.add(commentService
                .addComment(comment));

        //Then
        Assertions.assertEquals(1, carList.size());
    }

    @Test
    public void shouldCommentUpdate() {
        //Given
        Comment comment = new Comment(1L, "Joe Doe", "I am super excited! Professional company!");

        //When
        when(commentService
                .updateComment(comment)).thenReturn(comment);

        commentService
                .updateComment(comment).setUserName("Anna Doe");

        //Then
        Assertions.assertEquals(comment.getUserName(), "Anna Doe");
    }

    @Test
    public void shouldCommentDelete() {
        //Given
        Comment comment = new Comment(1L, "Joe Doe", "I am super excited! Professional company!");

        //When
        long commentId = comment.getId();
        commentRepository.deleteById(commentId);
        boolean isExist = commentRepository.existsById(commentId);

        //Then
        Assertions.assertFalse(isExist);
    }
}