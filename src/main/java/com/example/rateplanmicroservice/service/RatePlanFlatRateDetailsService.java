package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanFlatRateDetails;
import com.example.rateplanmicroservice.repository.RatePlanFlatRateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanFlatRateDetailsService {

    @Autowired
    private RatePlanFlatRateDetailsRepository ratePlanFlatRateDetailsRepository;

    public List<RatePlanFlatRateDetails> getAllRatePlanFlatRateDetails() {
        return ratePlanFlatRateDetailsRepository.findAll();
    }

    public RatePlanFlatRateDetails getRatePlanFlatRateDetailsById(int id) {
        return ratePlanFlatRateDetailsRepository.findById(id).orElse(null);
    }

    public RatePlanFlatRateDetails saveRatePlanFlatRateDetails(RatePlanFlatRateDetails ratePlanFlatRateDetails) {
        return ratePlanFlatRateDetailsRepository.save(ratePlanFlatRateDetails);
    }

    public void deleteRatePlanFlatRateDetails(int id) {
        ratePlanFlatRateDetailsRepository.deleteById(id);
    }
}
