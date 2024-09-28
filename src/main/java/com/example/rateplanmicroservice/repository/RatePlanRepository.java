package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.RatePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatePlanRepository extends JpaRepository<RatePlan, Integer> {
}
