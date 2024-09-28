package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanSubscriptionRateDetails;
import com.example.rateplanmicroservice.repository.RatePlanSubscriptionRateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanSubscriptionRateDetailsService {

    @Autowired
    private RatePlanSubscriptionRateDetailsRepository ratePlanSubscriptionRateDetailsRepository;

    public List<RatePlanSubscriptionRateDetails> getAllRatePlanSubscriptionRateDetails() {
        return ratePlanSubscriptionRateDetailsRepository.findAll();
    }

    public RatePlanSubscriptionRateDetails getRatePlanSubscriptionRateDetailsById(int id) {
        return ratePlanSubscriptionRateDetailsRepository.findById(id).orElse(null);
    }

    public RatePlanSubscriptionRateDetails saveRatePlanSubscriptionRateDetails(RatePlanSubscriptionRateDetails ratePlanSubscriptionRateDetails) {
        return ratePlanSubscriptionRateDetailsRepository.save(ratePlanSubscriptionRateDetails);
    }

    public void deleteRatePlanSubscriptionRateDetails(int id) {
        ratePlanSubscriptionRateDetailsRepository.deleteById(id);
    }
}
