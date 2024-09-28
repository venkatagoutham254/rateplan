package com.example.rateplanmicroservice.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class RatePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratePlanId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)  // Match column name with DB
    private Product product;

    @ManyToOne
    @JoinColumn(name = "currencyId", nullable = false)  // Match column name with DB
    private Currencies currency;

    @Column(nullable = false, length = 100)
    private String ratePlanName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RatePlanType ratePlanType;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    // Enum for Rate Plan Types
    public enum RatePlanType {
        FLAT_RATE, TIERED, USAGE_BASED, FREEMIUM, SUBSCRIPTION
    }

    // Enum for Rate Plan Status
    public enum Status {
        ACTIVE, INACTIVE, ARCHIVED
    }

    // Getters and Setters
    public int getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(int ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RatePlanType getRatePlanType() {
        return ratePlanType;
    }

    public void setRatePlanType(RatePlanType ratePlanType) {
        this.ratePlanType = ratePlanType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
