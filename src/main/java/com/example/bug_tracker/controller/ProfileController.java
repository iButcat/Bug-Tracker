package com.example.bug_tracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "/profile" })
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String profile() {
        return "profile";
    }
}
