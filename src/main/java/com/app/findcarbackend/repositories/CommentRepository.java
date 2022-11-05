package com.app.findcarbackend.repositories;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>  {

    @Override
    List<Comment> findAll();
}
