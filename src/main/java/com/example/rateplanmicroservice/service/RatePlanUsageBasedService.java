package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.RatePlanUsageBased;
import com.example.rateplanmicroservice.repository.RatePlanUsageBasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanUsageBasedService {

    @Autowired
    private RatePlanUsageBasedRepository ratePlanUsageBasedRepository;

    public List<RatePlanUsageBased> getAllRatePlanUsageBased() {
        return ratePlanUsageBasedRepository.findAll();
    }

    public RatePlanUsageBased getRatePlanUsageBasedById(int id) {
        return ratePlanUsageBasedRepository.findById(id).orElse(null);
    }

    public RatePlanUsageBased saveRatePlanUsageBased(RatePlanUsageBased ratePlanUsageBased) {
        return ratePlanUsageBasedRepository.save(ratePlanUsageBased);
    }

    public void deleteRatePlanUsageBased(int id) {
        ratePlanUsageBasedRepository.deleteById(id);
    }
}
