package com.qa.cinema.controllers;

import com.qa.cinema.models.Classification;
import com.qa.cinema.repositories.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classifications")
public class ClassificationsController {

    @Autowired
    private ClassificationRepository repo;

    @GetMapping
    public List<Classification> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Classification get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Classification classification) {
        repo.save(classification);
    }
}
