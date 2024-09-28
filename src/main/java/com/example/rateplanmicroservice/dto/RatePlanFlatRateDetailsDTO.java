package com.example.rateplanmicroservice.dto;

import java.math.BigDecimal;

public class RatePlanFlatRateDetailsDTO {
    private int ratePlanFlatRateId;
    private BigDecimal unitRate;
    private BigDecimal maxLimit;

    // Getters and Setters
    public int getRatePlanFlatRateId() { return ratePlanFlatRateId; }
    public void setRatePlanFlatRateId(int ratePlanFlatRateId) { this.ratePlanFlatRateId = ratePlanFlatRateId; }

    public BigDecimal getUnitRate() { return unitRate; }
    public void setUnitRate(BigDecimal unitRate) { this.unitRate = unitRate; }

    public BigDecimal getMaxLimit() { return maxLimit; }
    public void setMaxLimit(BigDecimal maxLimit) { this.maxLimit = maxLimit; }
}
