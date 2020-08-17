package com.example.bug_tracker.controller;

import com.example.bug_tracker.model.UserEntity;
import com.example.bug_tracker.service.SecurityService;
import com.example.bug_tracker.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
public class RegistrationController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/register")
    @ResponseBody
    public String registration(Model model) {
        model.addAttribute("user", new UserEntity());

        return "registration";
    }

    /*@PostMapping("/registration")
    public String registration(@ModelAttribute("user") UserEntity user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addUser(user);
        return "/login"; // "redirect:/login"
    } */

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String,Object>> registerUser(@Valid @RequestBody UserEntity user) {
        Map<String, Object> message = new HashMap<>();
        userService.addUser(user);
        System.out.println(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping("/login")
    @ResponseBody
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        if (logout != null) {
            model.addAttribute("message", "Your have been logged out successfully");
        }
        return "/login";
    }


}
