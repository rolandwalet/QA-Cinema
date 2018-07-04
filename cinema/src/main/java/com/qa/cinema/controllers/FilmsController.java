package com.qa.cinema.controllers;

import com.qa.cinema.models.Film;
import com.qa.cinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
    
    @GetMapping("/current")
    public List<Film> getCurrentFilms() {
    	List<Film> allFilms = list();
    	List<Film> releasedFilms = new ArrayList<Film>();
    	Date date = new Date();
    	
    	for (Film film : allFilms) {
    		if(film.getReleaseDate().before(date)) {
    			releasedFilms.add(film);
    		}
    	}
    	return releasedFilms;
    }
    
    @GetMapping("/future")
    public List<Film> getFutureFilms() {
    	List<Film> allFilms = list();
    	List<Film> futureFilms = new ArrayList<Film>();
    	Date date = new Date();
    	
    	for (Film film : allFilms) {
    		if(film.getReleaseDate().after(date)) {
    			futureFilms.add(film);
    		}
    	}
    	return futureFilms;
    }


    @GetMapping("/{id}")
    public Film get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Film film) {
        repo.save(film);
    }
}
