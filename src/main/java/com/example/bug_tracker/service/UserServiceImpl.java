package com.example.bug_tracker.service;

import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.exception.EmailExistsException;
import com.example.bug_tracker.exception.LoginExistsException;
import com.example.bug_tracker.model.User;
import com.example.bug_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public User addUser(UserRegistrationDto user) throws EmailExistsException, LoginExistsException {
        if (checkLoginExists(user.getLogin())) {
            throw new LoginExistsException("There is an account with that login: " + user.getLogin());
        }
        if (checkEmailExists(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email adress: " + user.getEmail());
        }

        return userRepository.addUser(user);
    }


    @Override
    public int updateUser(String userlogin, User userUpdate) {
        return userRepository.updateUser(userlogin, userUpdate);
    }

    @Override
    public void addRoleToUser(Long userId, Long roleId) {
        userRepository.addRoleToUser(userId, roleId);
    }

    public boolean checkLoginExists(String login) {
        User user = null;
        user = userRepository.getUserByLogin(login);

        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEmailExists(String email) {
        User user = null;
        user = userRepository.getUserByEmail(email);

        if (user != null) {
            return true;
        } else {
            return false;
        }
    }


}
