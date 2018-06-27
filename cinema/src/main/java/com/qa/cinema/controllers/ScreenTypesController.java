package com.qa.cinema.controllers;

import com.qa.cinema.models.ScreenType;
import com.qa.cinema.repositories.ScreenTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screen_types")
public class ScreenTypesController {
    @Autowired
    private ScreenTypeRepository repo;


    @GetMapping
    public List<ScreenType> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ScreenType get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody ScreenType screenType) {
        repo.save(screenType);
    }
}
