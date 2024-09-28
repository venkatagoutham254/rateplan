package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanFreemiumRateDetails;
import com.example.rateplanmicroservice.repository.RatePlanFreemiumRateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanFreemiumRateDetailsService {

    @Autowired
    private RatePlanFreemiumRateDetailsRepository ratePlanFreemiumRateDetailsRepository;

    public List<RatePlanFreemiumRateDetails> getAllRatePlanFreemiumRateDetails() {
        return ratePlanFreemiumRateDetailsRepository.findAll();
    }

    public RatePlanFreemiumRateDetails getRatePlanFreemiumRateDetailsById(int id) {
        return ratePlanFreemiumRateDetailsRepository.findById(id).orElse(null);
    }

    public RatePlanFreemiumRateDetails saveRatePlanFreemiumRateDetails(RatePlanFreemiumRateDetails ratePlanFreemiumRateDetails) {
        return ratePlanFreemiumRateDetailsRepository.save(ratePlanFreemiumRateDetails);
    }

    public void deleteRatePlanFreemiumRateDetails(int id) {
        ratePlanFreemiumRateDetailsRepository.deleteById(id);
    }
}
