package com.example.bug_tracker.repository;

import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    @Query(value = "SELECT * FROM USERS u WHERE u.status =1", nativeQuery = true)
    public List<User> getAllUsers();

    //@Query("SELECT u FROM Users u LEFT JOIN FETCH u.userRolesList")
    @Query(value = "SELECT * FROM USERS u WHERE u.id=id", nativeQuery = true)
    public User getUserById(@Param("id") Long id);

    public User getUserByLogin(@Param("login") String login);

}
