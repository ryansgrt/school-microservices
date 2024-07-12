package com.riyansugiarto.schoolservice.repositories;

import com.riyansugiarto.schoolservice.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
