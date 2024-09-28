package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.RatePlanTieredRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatePlanTieredRateRepository extends JpaRepository<RatePlanTieredRate, Integer> {
}
