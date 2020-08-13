package com.example.bug_tracker.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Column(name="project_id")
    @Id
    @GeneratedValue Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    Project() {}

    Project(
            String name,
            String description,
            Ticket ticket,
            User user
    ) {
        this.name = name;
        this.description = description;
        this.ticket = ticket;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "something";
    }

}
