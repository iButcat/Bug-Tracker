package com.example.bug_tracker.service;

import com.example.bug_tracker.model.Project;
import com.example.bug_tracker.model.Ticket;
import com.example.bug_tracker.repository.ProjectRepository;
import com.example.bug_tracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
// public
abstract class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Transactional
    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Transactional
    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
