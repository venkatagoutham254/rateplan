package com.example.rateplanmicroservice.repository;

import com.example.rateplanmicroservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
