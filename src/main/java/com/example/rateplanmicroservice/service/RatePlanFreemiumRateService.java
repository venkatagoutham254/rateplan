package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanFreemiumRate;
import com.example.rateplanmicroservice.repository.RatePlanFreemiumRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanFreemiumRateService {

    @Autowired
    private RatePlanFreemiumRateRepository ratePlanFreemiumRateRepository;

    public List<RatePlanFreemiumRate> getAllRatePlanFreemiumRates() {
        return ratePlanFreemiumRateRepository.findAll();
    }

    public RatePlanFreemiumRate getRatePlanFreemiumRateById(int id) {
        return ratePlanFreemiumRateRepository.findById(id).orElse(null);
    }

    public RatePlanFreemiumRate saveRatePlanFreemiumRate(RatePlanFreemiumRate ratePlanFreemiumRate) {
        return ratePlanFreemiumRateRepository.save(ratePlanFreemiumRate);
    }

    public void deleteRatePlanFreemiumRate(int id) {
        ratePlanFreemiumRateRepository.deleteById(id);
    }
}
