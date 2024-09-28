package com.example.rateplanmicroservice.dto;

public class RatePlanTieredRateDTO {
    private int ratePlanTieredRateId;
    private int ratePlanId;
    private String ratePlanTieredDescription;
    private String description;
    private String unitType;
    private String unitMeasurement;
    private String unitCalculation;

    // Getters and Setters
    public int getRatePlanTieredRateId() { return ratePlanTieredRateId; }
    public void setRatePlanTieredRateId(int ratePlanTieredRateId) { this.ratePlanTieredRateId = ratePlanTieredRateId; }

    public int getRatePlanId() { return ratePlanId; }
    public void setRatePlanId(int ratePlanId) { this.ratePlanId = ratePlanId; }

    public String getRatePlanTieredDescription() { return ratePlanTieredDescription; }
    public void setRatePlanTieredDescription(String ratePlanTieredDescription) { this.ratePlanTieredDescription = ratePlanTieredDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUnitType() { return unitType; }
    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(String unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public String getUnitCalculation() { return unitCalculation; }
    public void setUnitCalculation(String unitCalculation) { this.unitCalculation = unitCalculation; }
}
