package com.example.rateplanmicroservice.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class RatePlanTieredRateDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ratePlanTieredRateId", insertable = false, updatable = false)
    private RatePlanTieredRate ratePlanTieredRate;

    @Column(nullable = false)
    private int tierNumber;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tierStart;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tierRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tierEnd;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RatePlanTieredRate getRatePlanTieredRate() {
        return ratePlanTieredRate;
    }

    public void setRatePlanTieredRate(RatePlanTieredRate ratePlanTieredRate) {
        this.ratePlanTieredRate = ratePlanTieredRate;
    }

    public int getTierNumber() {
        return tierNumber;
    }

    public void setTierNumber(int tierNumber) {
        this.tierNumber = tierNumber;
    }

    public BigDecimal getTierStart() {
        return tierStart;
    }

    public void setTierStart(BigDecimal tierStart) {
        this.tierStart = tierStart;
    }

    public BigDecimal getTierRate() {
        return tierRate;
    }

    public void setTierRate(BigDecimal tierRate) {
        this.tierRate = tierRate;
    }

    public BigDecimal getTierEnd() {
        return tierEnd;
    }

    public void setTierEnd(BigDecimal tierEnd) {
        this.tierEnd = tierEnd;
    }
}
