package com.example.bug_tracker.service;

import com.example.bug_tracker.model.Comment;
import com.example.bug_tracker.model.Ticket;

import java.util.List;

public interface TicketService {

    void addTicket(Ticket ticket);

    List<Ticket> getTickets();

    Ticket getTicket(Long id);

    void updateTicket(Ticket ticket);

    void deleteTicket(Long id);

    void addComment(Comment comment);

    void deleteComment(Long id);

    List<Ticket> findUsersTickets(Long userId);

}
