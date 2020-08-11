package com.example.bug_tracker.service;

import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.exception.EmailExistsException;
import com.example.bug_tracker.exception.LoginExistsException;
import com.example.bug_tracker.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User getUserByLogin(String login);

    public User addUser(UserRegistrationDto user) throws EmailExistsException, LoginExistsException;

    public int updateUser(String userlogin, User userUpdate);

    public void addRoleToUser(Long userId, Long roleId);

}
