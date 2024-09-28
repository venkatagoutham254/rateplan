package com.example.rateplanmicroservice.service;

import com.example.rateplanmicroservice.model.Currencies;
import com.example.rateplanmicroservice.repository.CurrenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrenciesService {

    @Autowired
    private CurrenciesRepository currenciesRepository;

    public List<Currencies> getAllCurrencies() {
        return currenciesRepository.findAll();
    }

    public Currencies getCurrencyById(int id) {
        return currenciesRepository.findById(id).orElse(null);
    }

    public Currencies saveCurrency(Currencies currency) {
        return currenciesRepository.save(currency);
    }

    public void deleteCurrency(int id) {
        currenciesRepository.deleteById(id);
    }
}
