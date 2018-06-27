package com.qa.cinema.controllers;

import com.qa.cinema.models.Booking;
import com.qa.cinema.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingRepository repo;

    @GetMapping
    public List<Booking> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Booking get(@PathVariable("id") Long id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Booking booking) {
        repo.save(booking);
    }
}
