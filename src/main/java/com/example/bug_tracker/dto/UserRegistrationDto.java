package com.example.bug_tracker.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserRegistrationDto implements Serializable {

    @NotNull
    @Size(max = 40)
    private String username;

    @NotNull
    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    private String login;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    @Size(min = 6, max = 20)
    private String passwordMatches;


    public UserRegistrationDto() {}


    UserRegistrationDto(
            String username,
            String email,
            String login,
            String password,
            String passwordMatches
    ) {
        this.username = username;
        this.email = email;
        this.login = login;
        this.password = password;
        this.passwordMatches = passwordMatches;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMatches() {
      return passwordMatches;
    }

    public void setPasswordMatches(String passwordMatches) {
      this.passwordMatches = passwordMatches;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto [username=" + username +  ", login=" + login + ", password="
                + password+ ", passwordMatches=" + passwordMatches + ", email=" + email +  "]";
    }
}
