package com.example.bug_tracker.model;

import com.example.bug_tracker.controller.UserController;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserExtra {

    @Id
    private String username;
    private String role;

    public UserExtra(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
