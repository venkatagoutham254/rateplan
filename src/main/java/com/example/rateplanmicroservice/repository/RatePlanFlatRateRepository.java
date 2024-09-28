package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.RatePlanFlatRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatePlanFlatRateRepository extends JpaRepository<RatePlanFlatRate, Integer> {
}
