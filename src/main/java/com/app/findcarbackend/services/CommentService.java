package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.domain.Comment;
import com.app.findcarbackend.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Optional<Comment> getCommentById(final Long commentId) {
        return commentRepository.findById(commentId);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        comment.setUserName("Joe Doe");
        comment.setContent("I am super excited! Professional company!");
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        comment.setUserName("Joe Doe");
        return commentRepository.save(comment);
    }

    public boolean deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return true;
    }

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }
}
