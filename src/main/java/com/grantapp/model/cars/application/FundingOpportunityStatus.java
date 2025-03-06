package com.grantapp.model.cars.application;

import jakarta.persistence.*;

@Entity
@Table(name = "FundingOpportunityStatus", schema = "cars")
public class FundingOpportunityStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "FundingOpportunityStatusName", nullable = false, length = 20)
    private String fundingOpportunityStatusName;

    @Column(name = "FundingOpportunityStatusDescription", length = 10)
    private String fundingOpportunityStatusDescription;

    @Column(name = "Active", nullable = false)
    private boolean active = false;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFundingOpportunityStatusName() {
        return fundingOpportunityStatusName;
    }

    public void setFundingOpportunityStatusName(String fundingOpportunityStatusName) {
        this.fundingOpportunityStatusName = fundingOpportunityStatusName;
    }

    public String getFundingOpportunityStatusDescription() {
        return fundingOpportunityStatusDescription;
    }

    public void setFundingOpportunityStatusDescription(String fundingOpportunityStatusDescription) {
        this.fundingOpportunityStatusDescription = fundingOpportunityStatusDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}