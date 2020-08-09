package com.example.bug_tracker.controller;


import com.example.bug_tracker.model.User;
import com.example.bug_tracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/signin")
public class SignInController {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public SignInController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    User signin(@RequestParam String email, @RequestParam String password) {
        User u = new User(null, email, passwordEncoder.encode(password), User.Role.USER, null);
        return repository.save(u);
    }

}
