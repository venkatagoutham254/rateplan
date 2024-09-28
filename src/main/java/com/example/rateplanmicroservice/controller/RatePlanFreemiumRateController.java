package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.RatePlanFreemiumRateDTO;
import com.example.rateplanmicroservice.model.RatePlanFreemiumRate;
import com.example.rateplanmicroservice.service.RatePlanFreemiumRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rateplans/freemium")
public class RatePlanFreemiumRateController {

    @Autowired
    private RatePlanFreemiumRateService ratePlanFreemiumRateService;

    @GetMapping
    public ResponseEntity<List<RatePlanFreemiumRateDTO>> getAllRatePlanFreemiumRates() {
        List<RatePlanFreemiumRateDTO> freemiumRates = ratePlanFreemiumRateService.getAllRatePlanFreemiumRates().stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(freemiumRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatePlanFreemiumRateDTO> getRatePlanFreemiumRateById(@PathVariable int id) {
        RatePlanFreemiumRate freemiumRate = ratePlanFreemiumRateService.getRatePlanFreemiumRateById(id);
        return ResponseEntity.ok(convertToDTO(freemiumRate));
    }

    @PostMapping
    public ResponseEntity<RatePlanFreemiumRateDTO> createRatePlanFreemiumRate(@RequestBody RatePlanFreemiumRateDTO freemiumRateDTO) {
        RatePlanFreemiumRate freemiumRate = convertToEntity(freemiumRateDTO);
        freemiumRate = ratePlanFreemiumRateService.saveRatePlanFreemiumRate(freemiumRate);
        return ResponseEntity.ok(convertToDTO(freemiumRate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRatePlanFreemiumRate(@PathVariable int id) {
        ratePlanFreemiumRateService.deleteRatePlanFreemiumRate(id);
        return ResponseEntity.noContent().build();
    }

    private RatePlanFreemiumRateDTO convertToDTO(RatePlanFreemiumRate freemiumRate) {
        RatePlanFreemiumRateDTO dto = new RatePlanFreemiumRateDTO();
        dto.setRatePlanFreemiumRateId(freemiumRate.getRatePlanFreemiumRateId());
        dto.setRatePlanId(freemiumRate.getRatePlan().getRatePlanId());
        dto.setRatePlanFreemiumDescription(freemiumRate.getRatePlanFreemiumDescription());
        dto.setDescription(freemiumRate.getDescription());
        dto.setUnitType(freemiumRate.getUnitType().name());
        dto.setUnitMeasurement(freemiumRate.getUnitMeasurement().name());
        dto.setUnitBillingFrequency(freemiumRate.getUnitBillingFrequency().name());
        dto.setUnitFreePriceFixedFrequency(freemiumRate.getUnitFreePriceFixedFrequency().name());
        return dto;
    }

    private RatePlanFreemiumRate convertToEntity(RatePlanFreemiumRateDTO dto) {
        RatePlanFreemiumRate freemiumRate = new RatePlanFreemiumRate();
        freemiumRate.setRatePlanFreemiumRateId(dto.getRatePlanFreemiumRateId());
        freemiumRate.setRatePlanFreemiumDescription(dto.getRatePlanFreemiumDescription());
        freemiumRate.setDescription(dto.getDescription());
        freemiumRate.setUnitType(RatePlanFreemiumRate.UnitType.valueOf(dto.getUnitType()));
        freemiumRate.setUnitMeasurement(RatePlanFreemiumRate.UnitMeasurement.valueOf(dto.getUnitMeasurement()));
        freemiumRate.setUnitBillingFrequency(RatePlanFreemiumRate.UnitBillingFrequency.valueOf(dto.getUnitBillingFrequency()));
        freemiumRate.setUnitFreePriceFixedFrequency(RatePlanFreemiumRate.UnitFreePriceFixedFrequency.valueOf(dto.getUnitFreePriceFixedFrequency()));
        return freemiumRate;
    }
}
