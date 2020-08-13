package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    <S extends Project> S save(S entity);

    @Override
    Optional<Project> findById(Long id);

    @Override
    List<Project> findAll();

    @Override
    void deleteById(Long id);
}
