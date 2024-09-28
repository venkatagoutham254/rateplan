package com.example.rateplanmicroservice.dto;

public class RatePlanSubscriptionRateDTO {
    private int ratePlanSubscriptionRateId;
    private int ratePlanId;
    private String ratePlanSubscriptionDescription;
    private String description;
    private String unitType;
    private String unitMeasurement;
    private String unitBillingFrequency;
    private String unitPriceFixedFrequency;

    // Getters and Setters
    public int getRatePlanSubscriptionRateId() { return ratePlanSubscriptionRateId; }
    public void setRatePlanSubscriptionRateId(int ratePlanSubscriptionRateId) { this.ratePlanSubscriptionRateId = ratePlanSubscriptionRateId; }

    public int getRatePlanId() { return ratePlanId; }
    public void setRatePlanId(int ratePlanId) { this.ratePlanId = ratePlanId; }

    public String getRatePlanSubscriptionDescription() { return ratePlanSubscriptionDescription; }
    public void setRatePlanSubscriptionDescription(String ratePlanSubscriptionDescription) { this.ratePlanSubscriptionDescription = ratePlanSubscriptionDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUnitType() { return unitType; }
    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String getUnitMeasurement() { return unitMeasurement; }
    public void setUnitMeasurement(String unitMeasurement) { this.unitMeasurement = unitMeasurement; }

    public String getUnitBillingFrequency() { return unitBillingFrequency; }
    public void setUnitBillingFrequency(String unitBillingFrequency) { this.unitBillingFrequency = unitBillingFrequency; }

    public String getUnitPriceFixedFrequency() { return unitPriceFixedFrequency; }
    public void setUnitPriceFixedFrequency(String unitPriceFixedFrequency) { this.unitPriceFixedFrequency = unitPriceFixedFrequency; }
}
