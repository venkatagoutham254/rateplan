package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.RatePlanUsageBased;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatePlanUsageBasedRepository extends JpaRepository<RatePlanUsageBased, Integer> {
}
