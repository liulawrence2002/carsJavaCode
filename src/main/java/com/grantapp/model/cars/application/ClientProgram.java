package com.grantapp.model.cars.application;

import com.grantapp.model.cars.lookup.Client;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ClientProgram", schema = "cars")
public class ClientProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "LegacyProgramId", length = 10)
    private String legacyProgramId;

    @Column(name = "ProgramAbbreviation", nullable = false, length = 20)
    private String programAbbreviation;

    @Column(name = "ProgramPrefix", nullable = false, length = 8)
    private String programPrefix = "PRG"; // Default value

    @Column(name = "ProgramDescription", nullable = false, length = 75)
    private String programDescription;

    @Column(name = "DetailedDescription", length = 1000)
    private String detailedDescription;

    @Column(name = "ShortDescription", length = 35)
    private String shortDescription;

    @Column(name = "Active", nullable = false)
    private boolean active = false;

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
    @JoinColumn(name = "ClientId",
        foreignKey = @ForeignKey(name = "FY_Client_ClientProgram"),
        insertable = false, updatable = false)
    private Client client;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLegacyProgramId() {
        return legacyProgramId;
    }

    public void setLegacyProgramId(String legacyProgramId) {
        this.legacyProgramId = legacyProgramId;
    }

    public String getProgramAbbreviation() {
        return programAbbreviation;
    }

    public void setProgramAbbreviation(String programAbbreviation) {
        this.programAbbreviation = programAbbreviation;
    }

    public String getProgramPrefix() {
        return programPrefix;
    }

    public void setProgramPrefix(String programPrefix) {
        this.programPrefix = programPrefix;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}