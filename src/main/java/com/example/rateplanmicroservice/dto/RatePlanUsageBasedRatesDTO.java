package com.example.rateplanmicroservice.dto;

import java.math.BigDecimal;

public class RatePlanUsageBasedRatesDTO {
    private int ratePlanUsageRateId;
    private BigDecimal unitRate;

    // Getters and Setters
    public int getRatePlanUsageRateId() { return ratePlanUsageRateId; }
    public void setRatePlanUsageRateId(int ratePlanUsageRateId) { this.ratePlanUsageRateId = ratePlanUsageRateId; }

    public BigDecimal getUnitRate() { return unitRate; }
    public void setUnitRate(BigDecimal unitRate) { this.unitRate = unitRate; }
}
