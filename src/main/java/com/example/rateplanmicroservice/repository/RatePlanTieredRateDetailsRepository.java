package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.RatePlanTieredRateDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatePlanTieredRateDetailsRepository extends JpaRepository<RatePlanTieredRateDetails, Integer> {
}
