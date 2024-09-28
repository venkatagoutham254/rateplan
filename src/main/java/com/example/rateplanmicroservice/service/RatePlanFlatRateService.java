package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanFlatRate;
import com.example.rateplanmicroservice.repository.RatePlanFlatRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanFlatRateService {

    @Autowired
    private RatePlanFlatRateRepository ratePlanFlatRateRepository;

    public List<RatePlanFlatRate> getAllRatePlanFlatRates() {
        return ratePlanFlatRateRepository.findAll();
    }

    public RatePlanFlatRate getRatePlanFlatRateById(int id) {
        return ratePlanFlatRateRepository.findById(id).orElse(null);
    }

    public RatePlanFlatRate saveRatePlanFlatRate(RatePlanFlatRate ratePlanFlatRate) {
        return ratePlanFlatRateRepository.save(ratePlanFlatRate);
    }

    public void deleteRatePlanFlatRate(int id) {
        ratePlanFlatRateRepository.deleteById(id);
    }
}
