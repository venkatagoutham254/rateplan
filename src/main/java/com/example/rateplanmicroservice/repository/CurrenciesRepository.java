package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrenciesRepository extends JpaRepository<Currencies, Integer> {
}
