package com.example.rateplanmicroservice.model;

import jakarta.persistence.*;

@Entity
public class Currencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")  // Make sure this matches your database column name
    private int currencyId;

    @Column(nullable = false, unique = true, length = 3)
    private String currencyCode;

    @Column(nullable = false, length = 50)
    private String currencyName;

    @Column(nullable = false)
    private boolean isActive;

    // Getters and Setters
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
