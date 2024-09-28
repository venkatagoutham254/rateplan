package com.example.rateplanmicroservice.dto;

public class RatePlanUsageBasedDTO {
    private int ratePlanUsageRateId;
    private int ratePlanId;
    private String ratePlanUsageDescription;
    private String description;
    private String unitType;
    private String unitMeasurement;
    private String unitCalculation;

    // Getters and Setters
    public int getRatePlanUsageRateId() { return ratePlanUsageRateId; }
    public void setRatePlanUsageRateId(int ratePlanUsageRateId) { this.ratePlanUsageRateId = ratePlanUsageRateId; }

    public int getRatePlanId() { return ratePlanId; }
    public void setRatePlanId(int ratePlanId) { this.ratePlanId = ratePlanId; }

    public String getRatePlanUsageDescription() { return ratePlanUsageDescription; }
    public void setRatePlanUsageDescription(String ratePlanUsageDescription) { this.ratePlanUsageDescription = ratePlanUsageDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUnitType() { return unitType; }
    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(String unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public String getUnitCalculation() { return unitCalculation; }
    public void setUnitCalculation(String unitCalculation) { this.unitCalculation = unitCalculation; }
}
