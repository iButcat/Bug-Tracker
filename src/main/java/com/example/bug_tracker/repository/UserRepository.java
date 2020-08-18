package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Override
    <S extends UserEntity> S save(S entity);


    @Override
    Optional<UserEntity> findById(Long id);

    @Override
    List<UserEntity> findAll();

    @Override
    void deleteById(Long id);

    @Query(value = "SELECT * FROM USERS u WHERE u.email = email", nativeQuery = true)
    UserEntity findByEmail(@Param("email") String email);
}
