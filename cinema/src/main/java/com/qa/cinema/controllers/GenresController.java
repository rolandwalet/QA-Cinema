package com.qa.cinema.controllers;


import com.qa.cinema.models.Genre;
import com.qa.cinema.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresController {
    @Autowired
    private GenreRepository repo;

    @GetMapping
    public List<Genre> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Genre get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Genre genre) {
        repo.save(genre);
    }
}
