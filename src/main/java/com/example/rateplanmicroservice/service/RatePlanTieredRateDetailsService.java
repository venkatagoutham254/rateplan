package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanTieredRateDetails;
import com.example.rateplanmicroservice.repository.RatePlanTieredRateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanTieredRateDetailsService {

    @Autowired
    private RatePlanTieredRateDetailsRepository ratePlanTieredRateDetailsRepository;

    public List<RatePlanTieredRateDetails> getAllRatePlanTieredRateDetails() {
        return ratePlanTieredRateDetailsRepository.findAll();
    }

    public RatePlanTieredRateDetails getRatePlanTieredRateDetailsById(int id) {
        return ratePlanTieredRateDetailsRepository.findById(id).orElse(null);
    }

    public RatePlanTieredRateDetails saveRatePlanTieredRateDetails(RatePlanTieredRateDetails ratePlanTieredRateDetails) {
        return ratePlanTieredRateDetailsRepository.save(ratePlanTieredRateDetails);
    }

    public void deleteRatePlanTieredRateDetails(int id) {
        ratePlanTieredRateDetailsRepository.deleteById(id);
    }
}
