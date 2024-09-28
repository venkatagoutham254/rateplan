package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.RatePlanUsageBasedRatesDTO;
import com.example.rateplanmicroservice.model.RatePlanUsageBasedRates;
import com.example.rateplanmicroservice.service.RatePlanUsageBasedRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rateplans/usagebasedrates")
public class RatePlanUsageBasedRatesController {

    @Autowired
    private RatePlanUsageBasedRatesService ratePlanUsageBasedRatesService;

    @GetMapping
    public ResponseEntity<List<RatePlanUsageBasedRatesDTO>> getAllRatePlanUsageBasedRates() {
        List<RatePlanUsageBasedRatesDTO> usageBasedRates = ratePlanUsageBasedRatesService.getAllRatePlanUsageBasedRates().stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(usageBasedRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatePlanUsageBasedRatesDTO> getRatePlanUsageBasedRatesById(@PathVariable int id) {
        RatePlanUsageBasedRates usageBasedRate = ratePlanUsageBasedRatesService.getRatePlanUsageBasedRatesById(id);
        return ResponseEntity.ok(convertToDTO(usageBasedRate));
    }

    @PostMapping
    public ResponseEntity<RatePlanUsageBasedRatesDTO> createRatePlanUsageBasedRates(@RequestBody RatePlanUsageBasedRatesDTO usageBasedRatesDTO) {
        RatePlanUsageBasedRates usageBasedRate = convertToEntity(usageBasedRatesDTO);
        usageBasedRate = ratePlanUsageBasedRatesService.saveRatePlanUsageBasedRates(usageBasedRate);
        return ResponseEntity.ok(convertToDTO(usageBasedRate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRatePlanUsageBasedRates(@PathVariable int id) {
        ratePlanUsageBasedRatesService.deleteRatePlanUsageBasedRates(id);
        return ResponseEntity.noContent().build();
    }

    private RatePlanUsageBasedRatesDTO convertToDTO(RatePlanUsageBasedRates usageBasedRate) {
        RatePlanUsageBasedRatesDTO dto = new RatePlanUsageBasedRatesDTO();
        dto.setRatePlanUsageRateId(usageBasedRate.getRatePlanUsageRateId());
        dto.setUnitRate(usageBasedRate.getUnitRate());
        return dto;
    }

    private RatePlanUsageBasedRates convertToEntity(RatePlanUsageBasedRatesDTO dto) {
        RatePlanUsageBasedRates usageBasedRate = new RatePlanUsageBasedRates();
        usageBasedRate.setRatePlanUsageRateId(dto.getRatePlanUsageRateId());
        usageBasedRate.setUnitRate(dto.getUnitRate());
        return usageBasedRate;
    }
}
