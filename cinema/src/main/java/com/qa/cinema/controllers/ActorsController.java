package com.qa.cinema.controllers;

import com.qa.cinema.models.Actor;
import com.qa.cinema.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    private ActorRepository repo;

    @GetMapping
    public List<Actor> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Actor get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Actor actor) {
        repo.save(actor);
    }
}
