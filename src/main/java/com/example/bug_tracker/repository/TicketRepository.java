package com.example.bug_tracker.repository;

import com.example.bug_tracker.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Override
    <S extends Ticket> S save(S entity);

    @Override
    Optional<Ticket> findById(Long id);

    @Override
    List<Ticket> findAll();

    @Override
    void deleteById(Long id);
}
