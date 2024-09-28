package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.RatePlanTieredRateDTO;
import com.example.rateplanmicroservice.model.RatePlanTieredRate;
import com.example.rateplanmicroservice.service.RatePlanTieredRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rateplans/tieredrates")
public class RatePlanTieredRateController {

    @Autowired
    private RatePlanTieredRateService ratePlanTieredRateService;

    @GetMapping
    public ResponseEntity<List<RatePlanTieredRateDTO>> getAllRatePlanTieredRates() {
        List<RatePlanTieredRateDTO> tieredRates = ratePlanTieredRateService.getAllRatePlanTieredRates().stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(tieredRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatePlanTieredRateDTO> getRatePlanTieredRateById(@PathVariable int id) {
        RatePlanTieredRate tieredRate = ratePlanTieredRateService.getRatePlanTieredRateById(id);
        return ResponseEntity.ok(convertToDTO(tieredRate));
    }

    @PostMapping
    public ResponseEntity<RatePlanTieredRateDTO> createRatePlanTieredRate(@RequestBody RatePlanTieredRateDTO tieredRateDTO) {
        RatePlanTieredRate tieredRate = convertToEntity(tieredRateDTO);
        tieredRate = ratePlanTieredRateService.saveRatePlanTieredRate(tieredRate);
        return ResponseEntity.ok(convertToDTO(tieredRate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRatePlanTieredRate(@PathVariable int id) {
        ratePlanTieredRateService.deleteRatePlanTieredRate(id);
        return ResponseEntity.noContent().build();
    }

    private RatePlanTieredRateDTO convertToDTO(RatePlanTieredRate tieredRate) {
        RatePlanTieredRateDTO dto = new RatePlanTieredRateDTO();
        dto.setRatePlanTieredRateId(tieredRate.getRatePlanTieredRateId());
        dto.setRatePlanId(tieredRate.getRatePlan().getRatePlanId());
        dto.setRatePlanTieredDescription(tieredRate.getRatePlanTieredDescription());
        dto.setDescription(tieredRate.getDescription());
        dto.setUnitType(tieredRate.getUnitType().name());
        dto.setUnitMeasurement(tieredRate.getUnitMeasurement().name());
        dto.setUnitCalculation(tieredRate.getUnitCalculation().name());
        return dto;
    }

    private RatePlanTieredRate convertToEntity(RatePlanTieredRateDTO dto) {
        RatePlanTieredRate tieredRate = new RatePlanTieredRate();
        tieredRate.setRatePlanTieredRateId(dto.getRatePlanTieredRateId());
        tieredRate.setRatePlanTieredDescription(dto.getRatePlanTieredDescription());
        tieredRate.setDescription(dto.getDescription());
        tieredRate.setUnitType(RatePlanTieredRate.UnitType.valueOf(dto.getUnitType()));
        tieredRate.setUnitMeasurement(RatePlanTieredRate.UnitMeasurement.valueOf(dto.getUnitMeasurement()));
        tieredRate.setUnitCalculation(RatePlanTieredRate.UnitCalculation.valueOf(dto.getUnitCalculation()));
        return tieredRate;
    }
}

