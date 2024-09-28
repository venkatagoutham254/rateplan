package com.example.rateplanmicroservice.dto;

import java.util.Date;

public class RatePlanDTO {
    private int ratePlanId;
    private String ratePlanName;
    private String description;
    private String ratePlanType;
    private Date startDate;
    private Date endDate;
    private String status;
    private int productId;
    private int currencyId;

    // Getters and Setters
    public int getRatePlanId() { return ratePlanId; }
    public void setRatePlanId(int ratePlanId) { this.ratePlanId = ratePlanId; }

    public String getRatePlanName() { return ratePlanName; }
    public void setRatePlanName(String ratePlanName) { this.ratePlanName = ratePlanName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRatePlanType() { return ratePlanType; }
    public void setRatePlanType(String ratePlanType) { this.ratePlanType = ratePlanType; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getCurrencyId() { return currencyId; }
    public void setCurrencyId(int currencyId) { this.currencyId = currencyId; }
}
