package com.example.rateplanmicroservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;

@Entity
public class RatePlanSubscriptionRateDetails {

    @Id
    private int ratePlanSubscriptionRateId;

    @OneToOne
    @MapsId
    private RatePlanSubscriptionRate ratePlanSubscriptionRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPriceFixed;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subscriptionMaxUnitQuantity;

    // Getters and Setters
    public int getRatePlanSubscriptionRateId() { return ratePlanSubscriptionRateId; }
    public void setRatePlanSubscriptionRateId(int ratePlanSubscriptionRateId) { this.ratePlanSubscriptionRateId = ratePlanSubscriptionRateId; }

    public RatePlanSubscriptionRate getRatePlanSubscriptionRate() { return ratePlanSubscriptionRate; }
    public void setRatePlanSubscriptionRate(RatePlanSubscriptionRate ratePlanSubscriptionRate) { this.ratePlanSubscriptionRate = ratePlanSubscriptionRate; }

    public BigDecimal getUnitPriceFixed() { return unitPriceFixed; }
    public void setUnitPriceFixed(BigDecimal unitPriceFixed) { this.unitPriceFixed = unitPriceFixed; }

    public BigDecimal getSubscriptionMaxUnitQuantity() { return subscriptionMaxUnitQuantity; }
    public void setSubscriptionMaxUnitQuantity(BigDecimal subscriptionMaxUnitQuantity) { this.subscriptionMaxUnitQuantity = subscriptionMaxUnitQuantity; }
}
