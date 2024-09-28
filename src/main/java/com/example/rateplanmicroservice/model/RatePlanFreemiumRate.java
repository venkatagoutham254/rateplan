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
public class RatePlanFreemiumRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratePlanFreemiumRateId;

    @ManyToOne
    @JoinColumn(name = "ratePlanId", nullable = false)
    private RatePlan ratePlan;

    @Column(nullable = false, length = 100)
    private String ratePlanFreemiumDescription;

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
    private UnitFreePriceFixedFrequency unitFreePriceFixedFrequency;

    public enum UnitType {
        DATA_STORAGE, API, PROCESSING, BANDWIDTH
    }

    public enum UnitMeasurement {
        GB, MB, TB, CPU, NO_OF_API_CALLS
    }

    public enum UnitBillingFrequency {
        DAILY, MONTHLY, YEARLY, QUARTERLY
    }

    public enum UnitFreePriceFixedFrequency {
        MONTHLY, DAILY, HOURLY, YEARLY, TWICE_A_MONTH, QUARTERLY
    }

    // Getters and Setters
    public int getRatePlanFreemiumRateId() { return ratePlanFreemiumRateId; }
    public void setRatePlanFreemiumRateId(int ratePlanFreemiumRateId) { this.ratePlanFreemiumRateId = ratePlanFreemiumRateId; }

    public RatePlan getRatePlan() { return ratePlan; }
    public void setRatePlan(RatePlan ratePlan) { this.ratePlan = ratePlan; }

    public String getRatePlanFreemiumDescription() { return ratePlanFreemiumDescription; }
    public void setRatePlanFreemiumDescription(String ratePlanFreemiumDescription) { this.ratePlanFreemiumDescription = ratePlanFreemiumDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UnitType getUnitType() { return unitType; }
    public void setUnitType(UnitType unitType) { this.unitType = unitType; }

    public UnitMeasurement getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(UnitMeasurement unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public UnitBillingFrequency getUnitBillingFrequency() { return unitBillingFrequency; }
    public void setUnitBillingFrequency(UnitBillingFrequency unitBillingFrequency) { this.unitBillingFrequency = unitBillingFrequency; }

    public UnitFreePriceFixedFrequency getUnitFreePriceFixedFrequency() { return unitFreePriceFixedFrequency; }
    public void setUnitFreePriceFixedFrequency(UnitFreePriceFixedFrequency unitFreePriceFixedFrequency) { this.unitFreePriceFixedFrequency = unitFreePriceFixedFrequency; }
}
