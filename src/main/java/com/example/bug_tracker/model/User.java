package com.example.bug_tracker.model;

import com.sun.istack.NotNull;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    public enum Role {USER, ADMIN, MANAGER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String email;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated
    private AuthProvider provider;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String providerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
