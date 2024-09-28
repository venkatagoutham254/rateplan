package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanTieredRate;
import com.example.rateplanmicroservice.repository.RatePlanTieredRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanTieredRateService {

    @Autowired
    private RatePlanTieredRateRepository ratePlanTieredRateRepository;

    public List<RatePlanTieredRate> getAllRatePlanTieredRates() {
        return ratePlanTieredRateRepository.findAll();
    }

    public RatePlanTieredRate getRatePlanTieredRateById(int id) {
        return ratePlanTieredRateRepository.findById(id).orElse(null);
    }

    public RatePlanTieredRate saveRatePlanTieredRate(RatePlanTieredRate ratePlanTieredRate) {
        return ratePlanTieredRateRepository.save(ratePlanTieredRate);
    }

    public void deleteRatePlanTieredRate(int id) {
        ratePlanTieredRateRepository.deleteById(id);
    }
}
