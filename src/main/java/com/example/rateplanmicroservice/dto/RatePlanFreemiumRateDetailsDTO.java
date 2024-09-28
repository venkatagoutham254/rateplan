package com.example.rateplanmicroservice.dto;

import java.math.BigDecimal;

public class RatePlanFreemiumRateDetailsDTO {
    private int ratePlanFreemiumRateId;
    private BigDecimal freemiumMaxUnitQuantity;

    // Getters and Setters
    public int getRatePlanFreemiumRateId() { return ratePlanFreemiumRateId; }
    public void setRatePlanFreemiumRateId(int ratePlanFreemiumRateId) { this.ratePlanFreemiumRateId = ratePlanFreemiumRateId; }

    public BigDecimal getFreemiumMaxUnitQuantity() { return freemiumMaxUnitQuantity; }
    public void setFreemiumMaxUnitQuantity(BigDecimal freemiumMaxUnitQuantity) { this.freemiumMaxUnitQuantity = freemiumMaxUnitQuantity; }
}
