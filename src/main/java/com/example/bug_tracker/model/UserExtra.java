package com.example.bug_tracker.model;

import com.example.bug_tracker.controller.UserController;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserExtra {

    @Id
    private String username;
    private String job;
    private String role;

    public UserExtra(String username, String role, String job) {
        this.username = username;
        this.role = role;
        this.job = job;

    }
}
