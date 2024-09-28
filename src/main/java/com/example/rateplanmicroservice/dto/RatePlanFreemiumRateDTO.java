package com.example.rateplanmicroservice.dto;

public class RatePlanFreemiumRateDTO {
    private int ratePlanFreemiumRateId;
    private int ratePlanId;
    private String ratePlanFreemiumDescription;
    private String description;
    private String unitType;
    private String unitMeasurement;
    private String unitBillingFrequency;
    private String unitFreePriceFixedFrequency;

    // Getters and Setters
    public int getRatePlanFreemiumRateId() { return ratePlanFreemiumRateId; }
    public void setRatePlanFreemiumRateId(int ratePlanFreemiumRateId) { this.ratePlanFreemiumRateId = ratePlanFreemiumRateId; }

    public int getRatePlanId() { return ratePlanId; }
    public void setRatePlanId(int ratePlanId) { this.ratePlanId = ratePlanId; }

    public String getRatePlanFreemiumDescription() { return ratePlanFreemiumDescription; }
    public void setRatePlanFreemiumDescription(String ratePlanFreemiumDescription) { this.ratePlanFreemiumDescription = ratePlanFreemiumDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUnitType() { return unitType; }
    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(String unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public String getUnitBillingFrequency() { return unitBillingFrequency; }
    public void setUnitBillingFrequency(String unitBillingFrequency) { this.unitBillingFrequency = unitBillingFrequency; }

    public String getUnitFreePriceFixedFrequency() { return unitFreePriceFixedFrequency; }
    public void setUnitFreePriceFixedFrequency(String unitFreePriceFixedFrequency) { this.unitFreePriceFixedFrequency = unitFreePriceFixedFrequency; }
}
