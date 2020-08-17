package com.example.bug_tracker.controller;


import com.example.bug_tracker.dto.UserRegistrationDto;
import com.example.bug_tracker.exception.EmailExistsException;
import com.example.bug_tracker.exception.LoginExistsException;
import com.example.bug_tracker.model.User;
import com.example.bug_tracker.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@RestController
@RequestMapping(value = { "/registration" })
@CrossOrigin("*")
public class RegistrationController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET)
    public String registration(WebRequest request, Model model) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("user", userRegistrationDto);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") UserRegistrationDto user, BindingResult result,
                               WebRequest request, Errors errors, Model model) {

        if (result.hasErrors()) {
            result.rejectValue("password", "error.user", "Passwords don't match");
            return "/registration";
        } else {
            User registered = null;
            try {
                registered = userService.addUser(user);
            } catch (LoginExistsException el) {
                result.rejectValue("login", "error.user", "There is an account with that login");
                return "registration";
            } catch (EmailExistsException ee) {
                result.rejectValue("email", "error.user", "There is an account with that email adress");
                return "registration";
            }

            model.addAttribute("user", user);

            return "/login";
        }
    }

}
