package com.example.rateplanmicroservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;

@Entity
public class RatePlanFreemiumRateDetails {

    @Id
    private int ratePlanFreemiumRateId;

    @OneToOne
    @MapsId
    private RatePlanFreemiumRate ratePlanFreemiumRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal freemiumMaxUnitQuantity;

    // Getters and Setters
    public int getRatePlanFreemiumRateId() { return ratePlanFreemiumRateId; }
    public void setRatePlanFreemiumRateId(int ratePlanFreemiumRateId) { this.ratePlanFreemiumRateId = ratePlanFreemiumRateId; }

    public RatePlanFreemiumRate getRatePlanFreemiumRate() { return ratePlanFreemiumRate; }
    public void setRatePlanFreemiumRate(RatePlanFreemiumRate ratePlanFreemiumRate) { this.ratePlanFreemiumRate = ratePlanFreemiumRate; }

    public BigDecimal getFreemiumMaxUnitQuantity() { return freemiumMaxUnitQuantity; }
    public void setFreemiumMaxUnitQuantity(BigDecimal freemiumMaxUnitQuantity) { this.freemiumMaxUnitQuantity = freemiumMaxUnitQuantity; }
}
