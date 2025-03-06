package com.grantapp.model.cars.application;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ProgramMechanism", schema = "cars")
public class ProgramMechanism {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "BlindedFlag", nullable = false)
    private boolean blindedFlag = false;

    @Column(name = "PartneringPiAllowedFlag", nullable = false)
    private boolean partneringPiAllowedFlag = false;

    @Column(name = "FundingOpportunityTitle", length = 255)
    private String fundingOpportunityTitle;

    @Column(name = "FundingOpportunityAbbreviation", length = 10)
    private String fundingOpportunityAbbreviation;

    @Column(name = "FundingOpportunityDescription", length = 1000)
    private String fundingOpportunityDescription;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "last_updated_by")
    private Integer lastUpdatedBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated", nullable = false, updatable = false)
    private LocalDateTime lastUpdated;

    @Column(name = "DeletedFlag", nullable = false)
    private boolean deletedFlag = false;

    @Column(name = "DeletedBy")
    private Integer deletedBy;

    @Column(name = "DeletedDate")
    private LocalDateTime deletedDate;

    @Column(name = "TenantId", nullable = false)
    private int tenantId = 1;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "ClientAwardTypeId",
            foreignKey = @ForeignKey(name = "FY_ClientAwardType_ProgramMechanism"),
            insertable = false, updatable = false)
    private ClientAwardType clientAwardType;

    @ManyToOne
    @JoinColumn(name = "ClientCycleId",
            foreignKey = @ForeignKey(name = "FY_ClientCycle_ProgramMechanism"),
            insertable = false, updatable = false)
    private ClientCycle clientCycle;

    @ManyToOne
    @JoinColumn(name = "FundingOpportunityStatusId",
            foreignKey = @ForeignKey(name = "FY_FundingOpportunityStatus_ProgramMechanism"),
            insertable = false, updatable = false)
    private FundingOpportunityStatus fundingOpportunityStatus;

    @ManyToOne
    @JoinColumn(name = "ProgramYearId",
            foreignKey = @ForeignKey(name = "FY_ProgramYear_ProgramMechanism"),
            insertable = false, updatable = false)
    private ProgramYear programYear;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBlindedFlag() {
        return blindedFlag;
    }

    public void setBlindedFlag(boolean blindedFlag) {
        this.blindedFlag = blindedFlag;
    }

    public boolean isPartneringPiAllowedFlag() {
        return partneringPiAllowedFlag;
    }

    public void setPartneringPiAllowedFlag(boolean partneringPiAllowedFlag) {
        this.partneringPiAllowedFlag = partneringPiAllowedFlag;
    }

    public String getFundingOpportunityTitle() {
        return fundingOpportunityTitle;
    }

    public void setFundingOpportunityTitle(String fundingOpportunityTitle) {
        this.fundingOpportunityTitle = fundingOpportunityTitle;
    }

    public String getFundingOpportunityAbbreviation() {
        return fundingOpportunityAbbreviation;
    }

    public void setFundingOpportunityAbbreviation(String fundingOpportunityAbbreviation) {
        this.fundingOpportunityAbbreviation = fundingOpportunityAbbreviation;
    }

    public String getFundingOpportunityDescription() {
        return fundingOpportunityDescription;
    }

    public void setFundingOpportunityDescription(String fundingOpportunityDescription) {
        this.fundingOpportunityDescription = fundingOpportunityDescription;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public ClientAwardType getClientAwardType() {
        return clientAwardType;
    }

    public void setClientAwardType(ClientAwardType clientAwardType) {
        this.clientAwardType = clientAwardType;
    }

    public ClientCycle getClientCycle() {
        return clientCycle;
    }

    public void setClientCycle(ClientCycle clientCycle) {
        this.clientCycle = clientCycle;
    }

    public FundingOpportunityStatus getFundingOpportunityStatus() {
        return fundingOpportunityStatus;
    }

    public void setFundingOpportunityStatus(FundingOpportunityStatus fundingOpportunityStatus) {
        this.fundingOpportunityStatus = fundingOpportunityStatus;
    }

    public ProgramYear getProgramYear() {
        return programYear;
    }

    public void setProgramYear(ProgramYear programYear) {
        this.programYear = programYear;
    }
}