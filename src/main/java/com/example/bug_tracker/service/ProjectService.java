package com.example.bug_tracker.service;

import com.example.bug_tracker.model.Project;
import com.example.bug_tracker.model.Ticket;
import com.example.bug_tracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService {

    void addProject(Project project);

    List<Project> getProjects();

    Project getProject(Long id);

    void updateProject(Project project);

    void deleteTicket(Project project);

    void addTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    void deleteTicket(Ticket ticket);

    //List<Project> findUsersTickets(Long user_id);
}
