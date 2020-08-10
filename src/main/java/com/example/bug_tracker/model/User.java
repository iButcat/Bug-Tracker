package com.example.bug_tracker.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Column(nullable = false)
    private String email;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "AppUsersRoles", joinColumns = @JoinColumn(name = "usersid"), inverseJoinColumns = @JoinColumn(name = "usersRoleid"))
    private Set<UserRole> userRolesList = new HashSet<UserRole>();

    public User() {}

    public User(
            String username,
            String password,
            String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRolesList() {
        return userRolesList;
    }

    public void setUserRolesList(Set<UserRole> userRolesList) {
        this.userRolesList = userRolesList;
    }
}
