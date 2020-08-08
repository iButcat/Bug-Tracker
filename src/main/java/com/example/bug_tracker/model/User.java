package com.example.bug_tracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String role;
    private String job;
}
