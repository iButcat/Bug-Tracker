package com.example.bug_tracker.controller;


import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("prod")
public class RedirectController {

    @GetMapping("/private")
    public String redirectToRoot() {
        return "redirect:/";
    }

}
