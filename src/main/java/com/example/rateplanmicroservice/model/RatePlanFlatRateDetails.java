package com.example.rateplanmicroservice.model;



import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
@Entity
public class RatePlanFlatRateDetails {

    @Id
    private int ratePlanFlatRateId;

    @OneToOne
    @MapsId
    private RatePlanFlatRate ratePlanFlatRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal maxLimit;

    // Getters and Setters
    public int getRatePlanFlatRateId() { return ratePlanFlatRateId; }
    public void setRatePlanFlatRateId(int ratePlanFlatRateId) { this.ratePlanFlatRateId = ratePlanFlatRateId; }

    public RatePlanFlatRate getRatePlanFlatRate() { return ratePlanFlatRate; }
    public void setRatePlanFlatRate(RatePlanFlatRate ratePlanFlatRate) { this.ratePlanFlatRate = ratePlanFlatRate; }

    public BigDecimal getUnitRate() { return unitRate; }
    public void setUnitRate(BigDecimal unitRate) { this.unitRate = unitRate; }

    public BigDecimal getMaxLimit() { return maxLimit; }
    public void setMaxLimit(BigDecimal maxLimit) { this.maxLimit = maxLimit; }
}
