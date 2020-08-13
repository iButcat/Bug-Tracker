package com.example.bug_tracker.model;


import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name="user_role_id")
    private Long id;

    private String type;

    public UserRole() {
    }

    public UserRole(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserRole [id=" + id + ", type=" + type + "]";
    }
}
