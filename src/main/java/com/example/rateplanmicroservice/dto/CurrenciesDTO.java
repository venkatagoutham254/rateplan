package com.example.rateplanmicroservice.dto;

public class CurrenciesDTO {
    private int currencyId;
    private String currencyCode;
    private String currencyName;
    private boolean isActive;

    // Getters and Setters
    public int getCurrencyId() { return currencyId; }
    public void setCurrencyId(int currencyId) { this.currencyId = currencyId; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public String getCurrencyName() { return currencyName; }
    public void setCurrencyName(String currencyName) { this.currencyName = currencyName; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
