package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}
