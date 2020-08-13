package com.example.bug_tracker.service;

import com.example.bug_tracker.model.Comment;
import com.example.bug_tracker.model.Ticket;
import com.example.bug_tracker.repository.CommentRepository;
import com.example.bug_tracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    @Override
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @Transactional
    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
        updateTicket(comment.getTicket());
    }

    @Transactional
    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Ticket> findUsersTickets(Long userId) {}
}
