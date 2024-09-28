package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.RatePlanUsageBasedDTO;
import com.example.rateplanmicroservice.model.RatePlanUsageBased;
import com.example.rateplanmicroservice.service.RatePlanUsageBasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rateplans/usagebased")
public class RatePlanUsageBasedController {

    @Autowired
    private RatePlanUsageBasedService ratePlanUsageBasedService;

    @GetMapping
    public ResponseEntity<List<RatePlanUsageBasedDTO>> getAllRatePlanUsageBased() {
        List<RatePlanUsageBasedDTO> usageBasedRates = ratePlanUsageBasedService.getAllRatePlanUsageBased().stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(usageBasedRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatePlanUsageBasedDTO> getRatePlanUsageBasedById(@PathVariable int id) {
        RatePlanUsageBased usageBasedRate = ratePlanUsageBasedService.getRatePlanUsageBasedById(id);
        return ResponseEntity.ok(convertToDTO(usageBasedRate));
    }

    @PostMapping
    public ResponseEntity<RatePlanUsageBasedDTO> createRatePlanUsageBased(@RequestBody RatePlanUsageBasedDTO usageBasedDTO) {
        RatePlanUsageBased usageBasedRate = convertToEntity(usageBasedDTO);
        usageBasedRate = ratePlanUsageBasedService.saveRatePlanUsageBased(usageBasedRate);
        return ResponseEntity.ok(convertToDTO(usageBasedRate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRatePlanUsageBased(@PathVariable int id) {
        ratePlanUsageBasedService.deleteRatePlanUsageBased(id);
        return ResponseEntity.noContent().build();
    }

    private RatePlanUsageBasedDTO convertToDTO(RatePlanUsageBased usageBasedRate) {
        RatePlanUsageBasedDTO dto = new RatePlanUsageBasedDTO();
        dto.setRatePlanUsageRateId(usageBasedRate.getRatePlanUsageRateId());
        dto.setRatePlanId(usageBasedRate.getRatePlan().getRatePlanId());
        dto.setRatePlanUsageDescription(usageBasedRate.getRatePlanUsageDescription());
        dto.setDescription(usageBasedRate.getDescription());
        dto.setUnitType(usageBasedRate.getUnitType().name());
        dto.setUnitMeasurement(usageBasedRate.getUnitMeasurement().name());
        dto.setUnitCalculation(usageBasedRate.getUnitCalculation().name());
        return dto;
    }

    private RatePlanUsageBased convertToEntity(RatePlanUsageBasedDTO dto) {
        RatePlanUsageBased usageBasedRate = new RatePlanUsageBased();
        usageBasedRate.setRatePlanUsageRateId(dto.getRatePlanUsageRateId());
        usageBasedRate.setRatePlanUsageDescription(dto.getRatePlanUsageDescription());
        usageBasedRate.setDescription(dto.getDescription());
        usageBasedRate.setUnitType(RatePlanUsageBased.UnitType.valueOf(dto.getUnitType()));
        usageBasedRate.setUnitMeasurement(RatePlanUsageBased.UnitMeasurement.valueOf(dto.getUnitMeasurement()));
        usageBasedRate.setUnitCalculation(RatePlanUsageBased.UnitCalculation.valueOf(dto.getUnitCalculation()));
        return usageBasedRate;
    }
}
