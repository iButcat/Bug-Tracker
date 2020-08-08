package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

}
