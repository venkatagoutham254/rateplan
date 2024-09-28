package com.example.rateplanmicroservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RatePlanSubscriptionRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratePlanSubscriptionRateId;

    @ManyToOne
    @JoinColumn(name = "ratePlanId", nullable = false)
    private RatePlan ratePlan;

    @Column(nullable = false, length = 100)
    private String ratePlanSubscriptionDescription;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitMeasurement unitMeasurement;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitBillingFrequency unitBillingFrequency;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitPriceFixedFrequency unitPriceFixedFrequency;

    public enum UnitType {
        DATA_STORAGE, API, PROCESSING, BANDWIDTH
    }

    public enum UnitMeasurement {
        GB, MB, TB, CPU, NO_OF_API_CALLS
    }

    public enum UnitBillingFrequency {
        DAILY, MONTHLY, YEARLY, QUARTERLY
    }

    public enum UnitPriceFixedFrequency {
        MONTHLY, DAILY, HOURLY, YEARLY, TWICE_A_MONTH
    }

    // Getters and Setters
    public int getRatePlanSubscriptionRateId() { return ratePlanSubscriptionRateId; }
    public void setRatePlanSubscriptionRateId(int ratePlanSubscriptionRateId) { this.ratePlanSubscriptionRateId = ratePlanSubscriptionRateId; }

    public RatePlan getRatePlan() { return ratePlan; }
    public void setRatePlan(RatePlan ratePlan) { this.ratePlan = ratePlan; }

    public String getRatePlanSubscriptionDescription() { return ratePlanSubscriptionDescription; }
    public void setRatePlanSubscriptionDescription(String ratePlanSubscriptionDescription) { this.ratePlanSubscriptionDescription = ratePlanSubscriptionDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UnitType getUnitType() { return unitType; }
    public void setUnitType(UnitType unitType) { this.unitType = unitType; }

    public UnitMeasurement getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(UnitMeasurement unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public UnitBillingFrequency getUnitBillingFrequency() { return unitBillingFrequency; }
    public void setUnitBillingFrequency(UnitBillingFrequency unitBillingFrequency) { this.unitBillingFrequency = unitBillingFrequency; }

    public UnitPriceFixedFrequency getUnitPriceFixedFrequency() { return unitPriceFixedFrequency; }
    public void setUnitPriceFixedFrequency(UnitPriceFixedFrequency unitPriceFixedFrequency) { this.unitPriceFixedFrequency = unitPriceFixedFrequency; }
}
