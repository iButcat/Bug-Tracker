package com.example.bug_tracker.controller;

import com.example.bug_tracker.model.Project;
import com.example.bug_tracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("projects")
    public List<Project>  getTicket() {
        return this.projectRepository.findAll();
    }
}
