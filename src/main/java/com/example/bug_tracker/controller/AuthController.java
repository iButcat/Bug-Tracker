package com.example.bug_tracker.controller;


import com.example.bug_tracker.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("auth/")
public class AuthController {

    @GetMapping("signin")
    public String registration(Model model) {
        model.addAttribute(new User());
        return "registration";
    }
}

