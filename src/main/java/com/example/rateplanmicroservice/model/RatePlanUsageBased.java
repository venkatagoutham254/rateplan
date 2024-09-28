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
public class RatePlanUsageBased {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratePlanUsageRateId;

    @ManyToOne
    @JoinColumn(name = "ratePlanId", nullable = false)
    private RatePlan ratePlan;

    @Column(nullable = false, length = 100)
    private String ratePlanUsageDescription;

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
    private UnitCalculation unitCalculation;

    public enum UnitType {
        DATA_STORAGE, API, PROCESSING, BANDWIDTH
    }

    public enum UnitMeasurement {
        GB, MB, TB, CPU, NO_OF_API_CALLS
    }

    public enum UnitCalculation {
        MONTHLY, DAILY, HOURLY, YEARLY, TWICE_A_MONTH, QUARTERLY
    }

    // Getters and Setters
    public int getRatePlanUsageRateId() { return ratePlanUsageRateId; }
    public void setRatePlanUsageRateId(int ratePlanUsageRateId) { this.ratePlanUsageRateId = ratePlanUsageRateId; }

    public RatePlan getRatePlan() { return ratePlan; }
    public void setRatePlan(RatePlan ratePlan) { this.ratePlan = ratePlan; }

    public String getRatePlanUsageDescription() { return ratePlanUsageDescription; }
    public void setRatePlanUsageDescription(String ratePlanUsageDescription) { this.ratePlanUsageDescription = ratePlanUsageDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UnitType getUnitType() { return unitType; }
    public void setUnitType(UnitType unitType) { this.unitType = unitType; }

    public UnitMeasurement getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(UnitMeasurement unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public UnitCalculation getUnitCalculation() { return unitCalculation; }
    public void setUnitCalculation(UnitCalculation unitCalculation) { this.unitCalculation = unitCalculation; }
}
