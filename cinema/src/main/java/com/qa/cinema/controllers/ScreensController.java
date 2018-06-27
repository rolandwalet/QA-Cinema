package com.qa.cinema.controllers;

import com.qa.cinema.models.Screen;
import com.qa.cinema.repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
public class ScreensController {
    @Autowired
    private ScreenRepository repo;

    @GetMapping
    public List<Screen> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Screen get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Screen screen) {
        repo.save(screen);
    }
}
