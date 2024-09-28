package com.example.rateplanmicroservice.dto;

public class RatePlanFlatRateDTO {
    private int ratePlanFlatRateId;
    private int ratePlanId;
    private String ratePlanFlatDescription;
    private String description;
    private String unitType;
    private String unitMeasurement;
    private String flatRateUnitCalculation;
    private String maxLimitFrequency;

    // Getters and Setters
    public int getRatePlanFlatRateId() { return ratePlanFlatRateId; }
    public void setRatePlanFlatRateId(int ratePlanFlatRateId) { this.ratePlanFlatRateId = ratePlanFlatRateId; }

    public int getRatePlanId() { return ratePlanId; }
    public void setRatePlanId(int ratePlanId) { this.ratePlanId = ratePlanId; }

    public String getRatePlanFlatDescription() { return ratePlanFlatDescription; }
    public void setRatePlanFlatDescription(String ratePlanFlatDescription) { this.ratePlanFlatDescription = ratePlanFlatDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUnitType() { return unitType; }
    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(String unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public String getFlatRateUnitCalculation() { return flatRateUnitCalculation; }
    public void setFlatRateUnitCalculation(String flatRateUnitCalculation) { this.flatRateUnitCalculation = flatRateUnitCalculation; }

    public String getMaxLimitFrequency() { return maxLimitFrequency; }
    public void setMaxLimitFrequency(String maxLimitFrequency) { this.maxLimitFrequency = maxLimitFrequency; }
}
