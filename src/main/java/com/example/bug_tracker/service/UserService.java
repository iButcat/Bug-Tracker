package com.example.bug_tracker.service;


import com.example.bug_tracker.exception.EmailExistsException;
import com.example.bug_tracker.exception.LoginExistsException;
import com.example.bug_tracker.model.UserEntity;
import com.example.bug_tracker.model.UserEntity;

import java.util.List;


public interface UserService {

     void addUser(UserEntity user) throws EmailExistsException, LoginExistsException;

     List<UserEntity> getUsers();

     UserEntity getUser(Long id);

     void updateUser(UserEntity user);

     void deleteUser(Long id);

     UserEntity findByUsername(String email);


}
