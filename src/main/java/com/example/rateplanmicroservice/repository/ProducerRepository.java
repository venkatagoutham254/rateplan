package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}
