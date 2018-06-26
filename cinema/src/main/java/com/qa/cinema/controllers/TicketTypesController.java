package com.qa.cinema.controllers;

import com.qa.cinema.models.TicketType;
import com.qa.cinema.repositories.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket_types")
public class TicketTypesController {
    @Autowired
    private TicketTypeRepository repo;

    @GetMapping
    public List<TicketType> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public TicketType get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody TicketType ticketType) {
        repo.save(ticketType);
    }
}
