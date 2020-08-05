package com.example.bug_tracker.controller;

import java.util.List;
import java.util.Optional;

import com.example.bug_tracker.model.Ticket;
import com.example.bug_tracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("tickets")
    public List <Ticket> getTicket() {
        return this.ticketRepository.findAll();
    }

    @GetMapping("tickets/{id}")
    public ResponseEntity<?> getTicketId(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
