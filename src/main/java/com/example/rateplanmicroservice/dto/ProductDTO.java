package com.example.rateplanmicroservice.dto;

public class ProductDTO {
    private int productId;
    private String producerProvidedProductId;  // Ensure this field is present
    private String productName;
    private String productDescription;
    private String status;
    private int producerId;
    private Integer organizationId;  // Nullable
    private Integer divisionId;  // Nullable

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProducerProvidedProductId() { return producerProvidedProductId; }
    public void setProducerProvidedProductId(String producerProvidedProductId) { this.producerProvidedProductId = producerProvidedProductId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getProducerId() { return producerId; }
    public void setProducerId(int producerId) { this.producerId = producerId; }

    public Integer getOrganizationId() { return organizationId; }
    public void setOrganizationId(Integer organizationId) { this.organizationId = organizationId; }

    public Integer getDivisionId() { return divisionId; }
    public void setDivisionId(Integer divisionId) { this.divisionId = divisionId; }
}
