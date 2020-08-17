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
    private UserEntity user;

    Project() {}

    Project(
            Long id,
            String name,
            String description,
            Ticket ticket,
            UserEntity user
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ticket = ticket;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String toString() {
        return "something";
    }

}
