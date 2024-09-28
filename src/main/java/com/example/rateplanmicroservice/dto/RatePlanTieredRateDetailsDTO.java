package com.example.rateplanmicroservice.dto;

import java.math.BigDecimal;

public class RatePlanTieredRateDetailsDTO {
    private int ratePlanTieredRateId;
    private int tierNumber;
    private BigDecimal tierStart;
    private BigDecimal tierRate;
    private BigDecimal tierEnd;

    // Getters and Setters
    public int getRatePlanTieredRateId() { return ratePlanTieredRateId; }
    public void setRatePlanTieredRateId(int ratePlanTieredRateId) { this.ratePlanTieredRateId = ratePlanTieredRateId; }

    public int getTierNumber() { return tierNumber; }
    public void setTierNumber(int tierNumber) { this.tierNumber = tierNumber; }

    public BigDecimal getTierStart() { return tierStart; }
    public void setTierStart(BigDecimal tierStart) { this.tierStart = tierStart; }

    public BigDecimal getTierRate() { return tierRate; }
    public void setTierRate(BigDecimal tierRate) { this.tierRate = tierRate; }

    public BigDecimal getTierEnd() { return tierEnd; }
    public void setTierEnd(BigDecimal tierEnd) { this.tierEnd = tierEnd; }
}
