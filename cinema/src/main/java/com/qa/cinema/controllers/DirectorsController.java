package com.qa.cinema.controllers;


import com.qa.cinema.models.Director;
import com.qa.cinema.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorsController {
    @Autowired
    private DirectorRepository repo;

    @GetMapping
    public List<Director> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Director get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Director director) {
        repo.save(director);
    }
}
