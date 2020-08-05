package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findByTitle(String title);
}
