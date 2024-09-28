package com.example.rateplanmicroservice.controller;

import com.example.rateplanmicroservice.dto.CurrenciesDTO;
import com.example.rateplanmicroservice.model.Currencies;
import com.example.rateplanmicroservice.service.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/currencies")
public class CurrenciesController {

    @Autowired
    private CurrenciesService currenciesService;

    @GetMapping
    public ResponseEntity<List<CurrenciesDTO>> getAllCurrencies() {
        List<CurrenciesDTO> currencies = currenciesService.getAllCurrencies().stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(currencies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrenciesDTO> getCurrencyById(@PathVariable int id) {
        Currencies currency = currenciesService.getCurrencyById(id);
        return ResponseEntity.ok(convertToDTO(currency));
    }

    @PostMapping
    public ResponseEntity<CurrenciesDTO> createCurrency(@RequestBody CurrenciesDTO currenciesDTO) {
        Currencies currency = convertToEntity(currenciesDTO);
        currency = currenciesService.saveCurrency(currency);
        return ResponseEntity.ok(convertToDTO(currency));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable int id) {
        currenciesService.deleteCurrency(id);
        return ResponseEntity.noContent().build();
    }

    private CurrenciesDTO convertToDTO(Currencies currency) {
        CurrenciesDTO dto = new CurrenciesDTO();
        dto.setCurrencyId(currency.getCurrencyId());
        dto.setCurrencyCode(currency.getCurrencyCode());
        dto.setCurrencyName(currency.getCurrencyName());
        dto.setActive(currency.isActive());
        return dto;
    }

    private Currencies convertToEntity(CurrenciesDTO dto) {
        Currencies currency = new Currencies();
        currency.setCurrencyId(dto.getCurrencyId());
        currency.setCurrencyCode(dto.getCurrencyCode());
        currency.setCurrencyName(dto.getCurrencyName());
        currency.setActive(dto.isActive());
        return currency;
    }
}
