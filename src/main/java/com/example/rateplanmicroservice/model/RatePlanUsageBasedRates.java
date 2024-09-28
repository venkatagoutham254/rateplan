package com.example.rateplanmicroservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;

@Entity
public class RatePlanUsageBasedRates {

    @Id
    private int ratePlanUsageRateId;

    @OneToOne
    @MapsId
    private RatePlanUsageBased ratePlanUsageBased;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitRate;

    // Getters and Setters
    public int getRatePlanUsageRateId() { return ratePlanUsageRateId; }
    public void setRatePlanUsageRateId(int ratePlanUsageRateId) { this.ratePlanUsageRateId = ratePlanUsageRateId; }

    public RatePlanUsageBased getRatePlanUsageBased() { return ratePlanUsageBased; }
    public void setRatePlanUsageBased(RatePlanUsageBased ratePlanUsageBased) { this.ratePlanUsageBased = ratePlanUsageBased; }

    public BigDecimal getUnitRate() { return unitRate; }
    public void setUnitRate(BigDecimal unitRate) { this.unitRate = unitRate; }
}
