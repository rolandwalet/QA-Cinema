package com.qa.cinema.repositories;

import com.qa.cinema.models.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {
}
