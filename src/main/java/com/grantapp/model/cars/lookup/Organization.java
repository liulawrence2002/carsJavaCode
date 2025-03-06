package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Organization", schema = "cars")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ClientId", nullable = false)
    private int clientId;
    // Relationships
    @ManyToOne
    @JoinColumn(name = "ClientId",
            foreignKey = @ForeignKey(name = "FK_Organization_Client"),
            insertable = false, updatable = false)
    private Client client;

    @Column(name = "OrganizationName", nullable = false, length = 250)
    private String organizationName;

    @Column(name = "OrgShortName", length = 50)
    private String orgShortName;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "ClientOrgTypeId", foreignKey = @ForeignKey(name = "FK_Organization_ClientOrgType"))
    private ClientOrgType clientOrgType;

    @ManyToOne
    @JoinColumn(name = "ClientOrgClassId", foreignKey = @ForeignKey(name = "FK_Organization_ClientOrgClass"))
    private ClientOrgClass clientOrgClass;

    @Column(name = "VendorNumber", length = 50)
    private String vendorNumber;

    @Column(name = "DUNS", length = 11)
    private String duns;

    @Column(name = "EIN", length = 10)
    private String ein;

    @Column(name = "FYCloseMonth", length = 2)
    private String fyCloseMonth;

    @Column(name = "FYCloseDay", length = 2)
    private String fyCloseDay;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @CreationTimestamp
    @Column(name = "DateCreated", updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @UpdateTimestamp
    @Column(name = "LastUpdated")
    private LocalDateTime lastUpdated;

    @Column(name = "DeletedFlag", nullable = false)
    private boolean deletedFlag;

    @Column(name = "DeletedBy")
    private Integer deletedBy;

    @Column(name = "DeletedDate")
    private LocalDateTime deletedDate;

    @ManyToOne
    @JoinColumn(name = "TenantId", foreignKey = @ForeignKey(name = "FK_Organization_Tenant"), nullable = false)
    private Tenant tenant;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrgShortName() {
        return orgShortName;
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ClientOrgType getClientOrgType() {
        return clientOrgType;
    }

    public void setClientOrgType(ClientOrgType clientOrgType) {
        this.clientOrgType = clientOrgType;
    }

    public ClientOrgClass getClientOrgClass() {
        return clientOrgClass;
    }

    public void setClientOrgClass(ClientOrgClass clientOrgClass) {
        this.clientOrgClass = clientOrgClass;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public String getDuns() {
        return duns;
    }

    public void setDuns(String duns) {
        this.duns = duns;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getFyCloseMonth() {
        return fyCloseMonth;
    }

    public void setFyCloseMonth(String fyCloseMonth) {
        this.fyCloseMonth = fyCloseMonth;
    }

    public String getFyCloseDay() {
        return fyCloseDay;
    }

    public void setFyCloseDay(String fyCloseDay) {
        this.fyCloseDay = fyCloseDay;
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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
