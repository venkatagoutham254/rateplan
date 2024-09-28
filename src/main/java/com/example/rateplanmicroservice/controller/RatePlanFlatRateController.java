package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.RatePlanFlatRateDTO;
import com.example.rateplanmicroservice.model.RatePlanFlatRate;
import com.example.rateplanmicroservice.service.RatePlanFlatRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rateplans/flatrates")
public class RatePlanFlatRateController {

    @Autowired
    private RatePlanFlatRateService ratePlanFlatRateService;

    @GetMapping
    public ResponseEntity<List<RatePlanFlatRateDTO>> getAllRatePlanFlatRates() {
        List<RatePlanFlatRateDTO> flatRates = ratePlanFlatRateService.getAllRatePlanFlatRates().stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(flatRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatePlanFlatRateDTO> getRatePlanFlatRateById(@PathVariable int id) {
        RatePlanFlatRate flatRate = ratePlanFlatRateService.getRatePlanFlatRateById(id);
        return ResponseEntity.ok(convertToDTO(flatRate));
    }

    @PostMapping
    public ResponseEntity<RatePlanFlatRateDTO> createRatePlanFlatRate(@RequestBody RatePlanFlatRateDTO flatRateDTO) {
        RatePlanFlatRate flatRate = convertToEntity(flatRateDTO);
        flatRate = ratePlanFlatRateService.saveRatePlanFlatRate(flatRate);
        return ResponseEntity.ok(convertToDTO(flatRate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRatePlanFlatRate(@PathVariable int id) {
        ratePlanFlatRateService.deleteRatePlanFlatRate(id);
        return ResponseEntity.noContent().build();
    }

    private RatePlanFlatRateDTO convertToDTO(RatePlanFlatRate flatRate) {
        RatePlanFlatRateDTO dto = new RatePlanFlatRateDTO();
        dto.setRatePlanFlatRateId(flatRate.getRatePlanFlatRateId());
        dto.setRatePlanId(flatRate.getRatePlan().getRatePlanId());
        dto.setRatePlanFlatDescription(flatRate.getRatePlanFlatDescription());
        dto.setDescription(flatRate.getDescription());
        dto.setUnitType(flatRate.getUnitType().name());
        dto.setUnitMeasurement(flatRate.getUnitMeasurement().name());
        dto.setFlatRateUnitCalculation(flatRate.getFlatRateUnitCalculation().name());
        dto.setMaxLimitFrequency(flatRate.getMaxLimitFrequency().name());
        return dto;
    }

    private RatePlanFlatRate convertToEntity(RatePlanFlatRateDTO dto) {
        RatePlanFlatRate flatRate = new RatePlanFlatRate();
        flatRate.setRatePlanFlatRateId(dto.getRatePlanFlatRateId());
        flatRate.setRatePlanFlatDescription(dto.getRatePlanFlatDescription());
        flatRate.setDescription(dto.getDescription());
        flatRate.setUnitType(RatePlanFlatRate.UnitType.valueOf(dto.getUnitType()));
        flatRate.setUnitMeasurement(RatePlanFlatRate.UnitMeasurement.valueOf(dto.getUnitMeasurement()));
        flatRate.setFlatRateUnitCalculation(RatePlanFlatRate.FlatRateUnitCalculation.valueOf(dto.getFlatRateUnitCalculation()));
        flatRate.setMaxLimitFrequency(RatePlanFlatRate.MaxLimitFrequency.valueOf(dto.getMaxLimitFrequency()));
        return flatRate;
    }
}
