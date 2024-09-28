package com.example.rateplanmicroservice.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @ManyToOne
    @JoinColumn(name = "producerId", nullable = false)
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "organizationId")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division division;

    @Column(nullable = false, length = 100)
    private String producerProvidedProductId;  // Ensure this field is not null

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(columnDefinition = "TEXT")
    private String productDescription;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE, SUSPENDED
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public Producer getProducer() { return producer; }
    public void setProducer(Producer producer) { this.producer = producer; }

    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }

    public Division getDivision() { return division; }
    public void setDivision(Division division) { this.division = division; }

    public String getProducerProvidedProductId() { return producerProvidedProductId; }
    public void setProducerProvidedProductId(String producerProvidedProductId) { this.producerProvidedProductId = producerProvidedProductId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
