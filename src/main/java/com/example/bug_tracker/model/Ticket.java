package com.example.bug_tracker.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    private  @GeneratedValue Long id;

    private String title;

    private String description;

    @Column(name = "assigned_dev")
    private String assignedDev;

    private String project;

    private String priority;

    private String status;

    private String type;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    private Boolean updated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity creator;

    Ticket() {}

    Ticket(
            String title,
            String description,
            String assignedDev,
            String project,
            String priority,
            String status,
            String type,
            LocalDateTime createdAt,
            Boolean updated,
            UserEntity creator
    ) {
        this.title = title;
        this.description = description;
        this.assignedDev = assignedDev;
        this.project = project;
        this.priority = priority;
        this.status = status;
        this.type = type;
        this.createdAt = createdAt;
        this.updated = updated;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedDev() {
        return assignedDev;
    }

    public void setAssignedDev(String assignedDev) {
        this.assignedDev = assignedDev;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ticket))
            return false;
        Ticket ticket = (Ticket) o;
        return
                Objects.equals(this.id, ticket.id) &&
                Objects.equals(this.title, ticket.title) &&
                Objects.equals(this.description, ticket.description) &&
                Objects.equals(this.assignedDev, ticket.assignedDev) &&
                Objects.equals(this.project, ticket.project) &&
                Objects.equals(this.priority, ticket.priority) &&
                Objects.equals(this.status, ticket.status) &&
                Objects.equals(this.type, ticket.type) &&
                Objects.equals(this.createdAt, ticket.createdAt) &&
                Objects.equals(this.updated, ticket.updated) &&
                Objects.equals(this.creator, ticket.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.title,
                this.description,
                this.assignedDev,
                this.project,
                this.priority,
                this.status,
                this.type,
                this.createdAt,
                this.updated,
                this.creator
        );
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id + '\'' +
                ", title=" + title + '\'' +
                ", description=" + description + '\'' +
                ", assigned=" + assignedDev + '\'' +
                ", project=" + project + '\'' +
                ", priority=" + priority + '\'' +
                ", status=" + status + '\'' +
                ", type=" + type + '\'' +
                ", created at=" + createdAt + '\'' +
                ", updated=" + updated + '\'' +
                ", creator=" + creator + '\'' +
                '}';
    }
}
