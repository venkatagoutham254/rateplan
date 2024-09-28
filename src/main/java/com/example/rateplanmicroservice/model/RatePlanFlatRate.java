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
public class RatePlanFlatRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratePlanFlatRateId;

    @ManyToOne
    @JoinColumn(name = "ratePlanId", nullable = false)
    private RatePlan ratePlan;

    @Column(nullable = false, length = 100)
    private String ratePlanFlatDescription;

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
    private FlatRateUnitCalculation flatRateUnitCalculation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaxLimitFrequency maxLimitFrequency;

    public enum UnitType {
        DATA_STORAGE, API, PROCESSING, BANDWIDTH
    }

    public enum UnitMeasurement {
        GB, MB, TB, CPU, NO_OF_API_CALLS
    }

    public enum FlatRateUnitCalculation {
        MONTHLY, DAILY, HOURLY, YEARLY, TWICE_A_MONTH
    }

    public enum MaxLimitFrequency {
        DAILY, MONTHLY, YEARLY, QUARTERLY
    }

    // Getters and Setters
    public int getRatePlanFlatRateId() { return ratePlanFlatRateId; }
    public void setRatePlanFlatRateId(int ratePlanFlatRateId) { this.ratePlanFlatRateId = ratePlanFlatRateId; }

    public RatePlan getRatePlan() { return ratePlan; }
    public void setRatePlan(RatePlan ratePlan) { this.ratePlan = ratePlan; }

    public String getRatePlanFlatDescription() { return ratePlanFlatDescription; }
    public void setRatePlanFlatDescription(String ratePlanFlatDescription) { this.ratePlanFlatDescription = ratePlanFlatDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UnitType getUnitType() { return unitType; }
    public void setUnitType(UnitType unitType) { this.unitType = unitType; }

    public UnitMeasurement getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(UnitMeasurement unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public FlatRateUnitCalculation getFlatRateUnitCalculation() { return flatRateUnitCalculation; }
    public void setFlatRateUnitCalculation(FlatRateUnitCalculation flatRateUnitCalculation) { this.flatRateUnitCalculation = flatRateUnitCalculation; }

    public MaxLimitFrequency getMaxLimitFrequency() { return maxLimitFrequency; }
    public void setMaxLimitFrequency(MaxLimitFrequency maxLimitFrequency) { this.maxLimitFrequency = maxLimitFrequency; }
}
