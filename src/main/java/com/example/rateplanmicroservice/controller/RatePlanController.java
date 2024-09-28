package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.RatePlanDTO;
import com.example.rateplanmicroservice.model.Currencies;
import com.example.rateplanmicroservice.model.Product;
import com.example.rateplanmicroservice.model.RatePlan;
import com.example.rateplanmicroservice.service.CurrenciesService;
import com.example.rateplanmicroservice.service.ProductService;
import com.example.rateplanmicroservice.service.RatePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rateplans")
public class RatePlanController {

    @Autowired
    private RatePlanService ratePlanService;

    @Autowired
    private CurrenciesService currenciesService;  // Using your existing CurrenciesService

    @Autowired
    private ProductService productService;        // Using your existing ProductService

    @GetMapping
    public ResponseEntity<List<RatePlanDTO>> getAllRatePlans() {
        List<RatePlanDTO> ratePlans = ratePlanService.getAllRatePlans()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ratePlans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatePlanDTO> getRatePlanById(@PathVariable int id) {
        RatePlan ratePlan = ratePlanService.getRatePlanById(id);
        return ResponseEntity.ok(convertToDTO(ratePlan));
    }

    @PostMapping
    public ResponseEntity<RatePlanDTO> createRatePlan(@RequestBody RatePlanDTO ratePlanDTO) {
        RatePlan ratePlan = convertToEntity(ratePlanDTO);

        // Fetch the currency and product using IDs from the DTO
        Currencies currency = currenciesService.getCurrencyById(ratePlanDTO.getCurrencyId());
        Product product = productService.getProductById(ratePlanDTO.getProductId());

        // Set the currency and product in the RatePlan entity
        if (currency != null && product != null) {
            ratePlan.setCurrency(currency);
            ratePlan.setProduct(product);
        } else {
            return ResponseEntity.badRequest().build();  // Handle if currency or product is null
        }

        // Save the rate plan and return the saved DTO
        ratePlan = ratePlanService.saveRatePlan(ratePlan);
        return ResponseEntity.ok(convertToDTO(ratePlan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRatePlan(@PathVariable int id) {
        ratePlanService.deleteRatePlan(id);
        return ResponseEntity.noContent().build();
    }

    // Convert RatePlan entity to DTO
    private RatePlanDTO convertToDTO(RatePlan ratePlan) {
        RatePlanDTO dto = new RatePlanDTO();
        dto.setRatePlanId(ratePlan.getRatePlanId());
        dto.setRatePlanName(ratePlan.getRatePlanName());
        dto.setDescription(ratePlan.getDescription());
        dto.setRatePlanType(ratePlan.getRatePlanType().name());
        dto.setStartDate(ratePlan.getStartDate());
        dto.setEndDate(ratePlan.getEndDate());
        dto.setStatus(ratePlan.getStatus().name());
        dto.setProductId(ratePlan.getProduct().getProductId());
        dto.setCurrencyId(ratePlan.getCurrency().getCurrencyId());
        return dto;
    }

    // Convert DTO to RatePlan entity
    private RatePlan convertToEntity(RatePlanDTO dto) {
        RatePlan ratePlan = new RatePlan();
        ratePlan.setRatePlanId(dto.getRatePlanId());
        ratePlan.setRatePlanName(dto.getRatePlanName());
        ratePlan.setDescription(dto.getDescription());
        ratePlan.setRatePlanType(RatePlan.RatePlanType.valueOf(dto.getRatePlanType()));
        ratePlan.setStartDate(dto.getStartDate());
        ratePlan.setEndDate(dto.getEndDate());
        ratePlan.setStatus(RatePlan.Status.valueOf(dto.getStatus()));
        return ratePlan;
    }
}
