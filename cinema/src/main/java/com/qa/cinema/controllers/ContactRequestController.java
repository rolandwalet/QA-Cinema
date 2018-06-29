package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cinema.models.ContactRequest;
import com.qa.cinema.repositories.ContactRequestRepository;

@RestController
@RequestMapping("/contactrequest")
public class ContactRequestController {
	
	@Autowired
	private ContactRequestRepository repo;
	
	@GetMapping
	public List<ContactRequest> list() {
		return repo.findAll();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ContactRequest contactRequest) {
		repo.save(contactRequest);
	}
	
}
