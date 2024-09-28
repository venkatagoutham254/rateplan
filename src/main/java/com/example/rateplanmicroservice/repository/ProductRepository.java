package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
