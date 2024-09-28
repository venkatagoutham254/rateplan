package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.RatePlanUsageBasedRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatePlanUsageBasedRatesRepository extends JpaRepository<RatePlanUsageBasedRates, Integer> {
}
