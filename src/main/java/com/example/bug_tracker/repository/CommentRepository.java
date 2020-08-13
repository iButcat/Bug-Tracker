package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Override
    <S extends Comment> S save(S entity);

    @Override
    void deleteById(Long id);

}
