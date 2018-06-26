package com.qa.cinema.controllers;

import com.qa.cinema.models.Ticket;
import com.qa.cinema.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    private TicketRepository repo;

    @GetMapping
    public List<Ticket> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Ticket ticket) {
        repo.save(ticket);
    }
}
