package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlan;
import com.example.rateplanmicroservice.repository.RatePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanService {

    @Autowired
    private RatePlanRepository ratePlanRepository;

    public List<RatePlan> getAllRatePlans() {
        return ratePlanRepository.findAll();
    }

    public RatePlan getRatePlanById(int id) {
        return ratePlanRepository.findById(id).orElse(null);
    }

    public RatePlan saveRatePlan(RatePlan ratePlan) {
        return ratePlanRepository.save(ratePlan);
    }

    public void deleteRatePlan(int id) {
        ratePlanRepository.deleteById(id);
    }
}
