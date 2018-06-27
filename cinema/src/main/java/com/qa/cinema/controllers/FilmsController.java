package com.qa.cinema.controllers;

import com.qa.cinema.models.Film;
import com.qa.cinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    private FilmRepository repo;

    @GetMapping
    public List<Film> list() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Film get(@PathVariable("id") Long id) {
        System.out.print(repo.getOne(id));
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Film film) {
        repo.save(film);
    }
}
