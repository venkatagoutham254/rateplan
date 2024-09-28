package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.RatePlanSubscriptionRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatePlanSubscriptionRateRepository extends JpaRepository<RatePlanSubscriptionRate, Integer> {
}
