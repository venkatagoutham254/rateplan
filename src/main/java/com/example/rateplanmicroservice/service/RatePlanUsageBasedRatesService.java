package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanUsageBasedRates;
import com.example.rateplanmicroservice.repository.RatePlanUsageBasedRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanUsageBasedRatesService {

    @Autowired
    private RatePlanUsageBasedRatesRepository ratePlanUsageBasedRatesRepository;

    public List<RatePlanUsageBasedRates> getAllRatePlanUsageBasedRates() {
        return ratePlanUsageBasedRatesRepository.findAll();
    }

    public RatePlanUsageBasedRates getRatePlanUsageBasedRatesById(int id) {
        return ratePlanUsageBasedRatesRepository.findById(id).orElse(null);
    }

    public RatePlanUsageBasedRates saveRatePlanUsageBasedRates(RatePlanUsageBasedRates ratePlanUsageBasedRates) {
        return ratePlanUsageBasedRatesRepository.save(ratePlanUsageBasedRates);
    }

    public void deleteRatePlanUsageBasedRates(int id) {
        ratePlanUsageBasedRatesRepository.deleteById(id);
    }
}
