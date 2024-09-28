package com.example.rateplanmicroservice.dto;

import java.math.BigDecimal;

public class RatePlanSubscriptionRateDetailsDTO {
    private int ratePlanSubscriptionRateId;
    private BigDecimal unitPriceFixed;
    private BigDecimal subscriptionMaxUnitQuantity;

    // Getters and Setters
    public int getRatePlanSubscriptionRateId() { return ratePlanSubscriptionRateId; }
    public void setRatePlanSubscriptionRateId(int ratePlanSubscriptionRateId) { this.ratePlanSubscriptionRateId = ratePlanSubscriptionRateId; }

    public BigDecimal getUnitPriceFixed() { return unitPriceFixed; }
    public void setUnitPriceFixed(BigDecimal unitPriceFixed) { this.unitPriceFixed = unitPriceFixed; }

    public BigDecimal getSubscriptionMaxUnitQuantity() { return subscriptionMaxUnitQuantity; }
    public void setSubscriptionMaxUnitQuantity(BigDecimal subscriptionMaxUnitQuantity) { this.subscriptionMaxUnitQuantity = subscriptionMaxUnitQuantity; }
}
