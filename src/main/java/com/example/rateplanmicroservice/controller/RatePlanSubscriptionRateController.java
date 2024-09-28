package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.RatePlanSubscriptionRateDTO;
import com.example.rateplanmicroservice.model.RatePlanSubscriptionRate;
import com.example.rateplanmicroservice.service.RatePlanSubscriptionRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rateplans/subscription")
public class RatePlanSubscriptionRateController {

    @Autowired
    private RatePlanSubscriptionRateService ratePlanSubscriptionRateService;

    @GetMapping
    public ResponseEntity<List<RatePlanSubscriptionRateDTO>> getAllRatePlanSubscriptionRates() {
        List<RatePlanSubscriptionRateDTO> subscriptionRates = ratePlanSubscriptionRateService.getAllRatePlanSubscriptionRates().stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(subscriptionRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatePlanSubscriptionRateDTO> getRatePlanSubscriptionRateById(@PathVariable int id) {
        RatePlanSubscriptionRate subscriptionRate = ratePlanSubscriptionRateService.getRatePlanSubscriptionRateById(id);
        return ResponseEntity.ok(convertToDTO(subscriptionRate));
    }

    @PostMapping
    public ResponseEntity<RatePlanSubscriptionRateDTO> createRatePlanSubscriptionRate(@RequestBody RatePlanSubscriptionRateDTO subscriptionRateDTO) {
        RatePlanSubscriptionRate subscriptionRate = convertToEntity(subscriptionRateDTO);
        subscriptionRate = ratePlanSubscriptionRateService.saveRatePlanSubscriptionRate(subscriptionRate);
        return ResponseEntity.ok(convertToDTO(subscriptionRate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRatePlanSubscriptionRate(@PathVariable int id) {
        ratePlanSubscriptionRateService.deleteRatePlanSubscriptionRate(id);
        return ResponseEntity.noContent().build();
    }

    private RatePlanSubscriptionRateDTO convertToDTO(RatePlanSubscriptionRate subscriptionRate) {
        RatePlanSubscriptionRateDTO dto = new RatePlanSubscriptionRateDTO();
        dto.setRatePlanSubscriptionRateId(subscriptionRate.getRatePlanSubscriptionRateId());
        dto.setRatePlanId(subscriptionRate.getRatePlan().getRatePlanId());
        dto.setRatePlanSubscriptionDescription(subscriptionRate.getRatePlanSubscriptionDescription());
        dto.setDescription(subscriptionRate.getDescription());
        dto.setUnitType(subscriptionRate.getUnitType().name());
        dto.setUnitMeasurement(subscriptionRate.getUnitMeasurement().name());
        dto.setUnitBillingFrequency(subscriptionRate.getUnitBillingFrequency().name());
        dto.setUnitPriceFixedFrequency(subscriptionRate.getUnitPriceFixedFrequency().name());
        return dto;
    }

    private RatePlanSubscriptionRate convertToEntity(RatePlanSubscriptionRateDTO dto) {
        RatePlanSubscriptionRate subscriptionRate = new RatePlanSubscriptionRate();
        subscriptionRate.setRatePlanSubscriptionRateId(dto.getRatePlanSubscriptionRateId());
        subscriptionRate.setRatePlanSubscriptionDescription(dto.getRatePlanSubscriptionDescription());
        subscriptionRate.setDescription(dto.getDescription());
        subscriptionRate.setUnitType(RatePlanSubscriptionRate.UnitType.valueOf(dto.getUnitType()));
        subscriptionRate.setUnitMeasurement(RatePlanSubscriptionRate.UnitMeasurement.valueOf(dto.getUnitMeasurement()));
        subscriptionRate.setUnitBillingFrequency(RatePlanSubscriptionRate.UnitBillingFrequency.valueOf(dto.getUnitBillingFrequency()));
        subscriptionRate.setUnitPriceFixedFrequency(RatePlanSubscriptionRate.UnitPriceFixedFrequency.valueOf(dto.getUnitPriceFixedFrequency()));
        return subscriptionRate;
    }
}
