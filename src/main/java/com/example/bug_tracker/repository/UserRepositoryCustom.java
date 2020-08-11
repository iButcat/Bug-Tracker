package com.example.bug_tracker.repository;

import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryCustom {
    public User getUserByLogin(String login);

    public User getUserByEmail(String email);

    public User addUser(UserRegistrationDto user);

    public int updateUser(String userlogin, User userUpdate);

    public void addRoleToUser(Long userId, Long roleId);
}
