package com.example.bug_tracker.service;

import com.example.bug_tracker.model.User;

import java.util.List;

public interface UserRoleService {

    public List<User> getAllUsers();

    public User getUserById(Long id);
    
}
