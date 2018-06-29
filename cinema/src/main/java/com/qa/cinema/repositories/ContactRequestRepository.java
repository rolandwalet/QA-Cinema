package com.qa.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.cinema.models.ContactRequest;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

}
