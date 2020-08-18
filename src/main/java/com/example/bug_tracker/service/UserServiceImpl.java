package com.example.bug_tracker.service;


import com.example.bug_tracker.model.UserEntity;
import com.example.bug_tracker.repository.UserRepository;
import com.example.bug_tracker.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public void addUser(UserEntity user) {
        user.setRoles(new HashSet<>(Arrays.asList(userRoleRepository.findByName("USER_ROLE"))));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public UserEntity getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity findByUsername(String email) {
        return userRepository.findByEmail(email);
    }
}
