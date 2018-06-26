package com.qa.cinema.controllers;

import com.qa.cinema.models.Showing;
import com.qa.cinema.repositories.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showings")
public class ShowingsController {
    @Autowired
    private ShowingRepository repo;

    @GetMapping
    public List<Showing> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Showing get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Showing showing) {
        repo.save(showing);
    }
}
