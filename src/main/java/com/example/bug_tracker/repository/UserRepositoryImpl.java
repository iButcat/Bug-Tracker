package com.example.bug_tracker.repository;

import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByLogin(String login) {
        User result = null;

        try {
            result = (User) entityManager
                    .createQuery("SELECT u FROM User u LEFT JOIN FETCH u.userRolesList WHERE u.login=:login")
                    .setParameter("login", login).getSingleResult();
        } catch (NoResultException nre) {
        }

        return result;
    }

    @Override
    public User getUserByEmail(String email) {
        User result = null;

        try {
            result = (User) entityManager
                    .createQuery("SELECT u FROM User u  LEFT JOIN FETCH u.userRolesList WHERE u.email=:email")
                    .setParameter("email", email).getSingleResult();
        } catch (NoResultException nre) {
        }

        return result;
    }

    @Override
    @Transactional
    public User addUser(UserRegistrationDto user) {
        User userToPersist = new User();
        userToPersist.setUsername(user.getUsername());
        userToPersist.setEmail(user.getEmail());
        userToPersist.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.getUsername(),  user.getLogin(),
        // passwordEncoder.encode(user.getPassword()), user.getEmail()

        long customerRoleId = 2;

        userToPersist.getUserRolesList().add(userRoleRepository.getUserRoleById(customerRoleId));

        //entityManager.persist(userToPersist);

        return userRepository.save(user);
        //return userToPersist;
    }

    @Override
    @Transactional
    public void addRoleToUser(Long userId, Long roleId) {
        User userToAddRole = userRepository.getUserById(userId);

        userToAddRole.getUserRolesList().add(userRoleRepository.getUserRoleById(roleId));

        entityManager.merge(userToAddRole);
    }

    @Override
    @Transactional
    public int updateUser(String userlogin, User userUpdate) {

        if(userUpdate.getPassword()==null) {
            System.out.println("test");
        }

        System.out.println(userlogin);

        int number = entityManager
                .createQuery("UPDATE Users u SET "
                        + "u.username=COALESCE(:username,u.username), "
                        + "u.password=COALESCE(:password,u.password), "
                        + "u.email=COALESCE(:email,u.email), "
                        + "WHERE u.login=:login")
                .setParameter("username", userUpdate.getUsername())
                .setParameter("password",userUpdate.getPassword()!=null ? passwordEncoder.encode(userUpdate.getPassword()) : userUpdate.getPassword())
                .setParameter("email", userUpdate.getEmail())
                .setParameter("login", userlogin)
                .executeUpdate();

        return number;
    }


}
