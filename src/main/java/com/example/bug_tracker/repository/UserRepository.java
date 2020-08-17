package com.example.bug_tracker.repository;

import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    @Override
    <S extends User> S save(S entity);
    
    @Query(value = "SELECT * FROM USERS u WHERE u.status =1", nativeQuery = true)
    public List<User> getAllUsers();

    //@Query("SELECT u FROM Users u LEFT JOIN FETCH u.userRolesList")
    @Query(value = "SELECT * FROM USERS u WHERE u.id=id", nativeQuery = true)
    public User getUserById(@Param("id") Long id);

    public User getUserByLogin(@Param("login") String login);

    User save(UserRegistrationDto user);
}
