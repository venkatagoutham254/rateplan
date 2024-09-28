package com.example.rateplanmicroservice.dto;

public class DivisionDTO {
    private int divisionId;
    private int organizationId;
    private String divisionName;

    // Getters and Setters
    public int getDivisionId() { return divisionId; }
    public void setDivisionId(int divisionId) { this.divisionId = divisionId; }

    public int getOrganizationId() { return organizationId; }
    public void setOrganizationId(int organizationId) { this.organizationId = organizationId; }

    public String getDivisionName() { return divisionName; }
    public void setDivisionName(String divisionName) { this.divisionName = divisionName; }
}
