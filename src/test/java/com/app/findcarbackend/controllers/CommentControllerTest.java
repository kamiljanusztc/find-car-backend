package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.domain.Comment;
import com.app.findcarbackend.services.CommentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@SpringJUnitWebConfig
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CommentService commentService;

    @Test
    void shouldGetEmptyListOfComments() throws Exception {
        //Given
        when(commentService.getAllComments()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldFetchListOfComments() throws Exception {
        //Given
        List<Comment> commentList = List.of(new Comment(1L, "Joe Doe", "I am super excited! Professional company!"));

        when(commentService.getAllComments()).thenReturn(commentList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].userName", Matchers.is("Joe Doe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].content", Matchers.is("I am super excited! Professional company!")));
    }

    @Test
    void shouldFetchComment() throws Exception {
        //Given
        Comment comment = new Comment(1L, "Joe Doe", "I am super excited! Professional company!");

        when(commentService.getCommentById(1L)).thenReturn(Optional.of(comment));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/comments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName", Matchers.is("Joe Doe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("I am super excited! Professional company!")));
    }

    @Test
    void shouldAddComment() {
        Comment comment = new Comment(1L, "Joe Doe", "I am super excited! Professional company!");
        when(commentService.addComment(comment)).thenReturn(comment);

        commentService.addComment(comment);

        verify(commentService).addComment(comment);
    }
    @Test
    void shouldDeleteCommentById() {
        List<Comment> commentList = List.of(new Comment(1L, "Joe Doe", "I am super excited! Professional company!"));
        when(commentService.getAllComments()).thenReturn(commentList);

        commentService.deleteComment(1L);

        verify(commentService).deleteComment(1L);
    }
}