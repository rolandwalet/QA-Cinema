package com.qa.cinema.repositories;

import com.qa.cinema.models.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
}
