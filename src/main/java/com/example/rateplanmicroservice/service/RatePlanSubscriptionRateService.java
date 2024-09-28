package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanSubscriptionRate;
import com.example.rateplanmicroservice.repository.RatePlanSubscriptionRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanSubscriptionRateService {

    @Autowired
    private RatePlanSubscriptionRateRepository ratePlanSubscriptionRateRepository;

    public List<RatePlanSubscriptionRate> getAllRatePlanSubscriptionRates() {
        return ratePlanSubscriptionRateRepository.findAll();
    }

    public RatePlanSubscriptionRate getRatePlanSubscriptionRateById(int id) {
        return ratePlanSubscriptionRateRepository.findById(id).orElse(null);
    }

    public RatePlanSubscriptionRate saveRatePlanSubscriptionRate(RatePlanSubscriptionRate ratePlanSubscriptionRate) {
        return ratePlanSubscriptionRateRepository.save(ratePlanSubscriptionRate);
    }

    public void deleteRatePlanSubscriptionRate(int id) {
        ratePlanSubscriptionRateRepository.deleteById(id);
    }
}
