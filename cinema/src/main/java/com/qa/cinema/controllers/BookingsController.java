package com.qa.cinema.controllers;

import com.qa.cinema.models.Booking;
import com.qa.cinema.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    
    @GetMapping("/byshowing/{showingId}")
    public List<Booking> getBookingForShowing(@PathVariable("showingId") Long showingId) {
    	List<Booking> allBookings = repo.findAll();
    	List<Booking> allShowingBookings = new ArrayList<Booking>(); 
    	
    	for (Booking booking : allBookings) {
    		if (booking.getShowingId() == showingId) {
    			allShowingBookings.add(booking);
    		}
    	}
    	
    	return allShowingBookings;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Booking create (@RequestBody Booking booking) {
    	if (booking.getAdultTickets() + booking.getConcessionTickets() + booking.getChildTickets() <= 0 ) {
    		return booking;
    	}
    	else if (booking.getAdultTickets() + booking.getConcessionTickets() + booking.getChildTickets() > 10 ) {
    		return booking;
    	}
    	
    	else if (booking.getCustomerName() == null) {
    		return booking;
    	}
    	else {
    		return repo.save(booking);
    	}
        
    }
}
