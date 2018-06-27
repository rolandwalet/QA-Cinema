package com.qa.cinema.repositories;

import com.qa.cinema.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
