package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ClientOrgType", schema = "cars")
public class ClientOrgType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "ClientSpecName", length = 50)
    private String clientSpecName;

    @Column(name = "Description", length = 100)
    private String description;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @CreationTimestamp
    @Column(name = "DateCreated", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "LastUpdatedBy")
    private Integer lastUpdatedBy;

    @UpdateTimestamp
    @Column(name = "LastUpdated", nullable = false)
    private LocalDateTime lastUpdated;

    @Column(name = "DeletedFlag", nullable = false)
    private boolean deletedFlag = false;

    @Column(name = "DeletedBy")
    private Integer deletedBy;

    @Column(name = "DeletedDate")
    private LocalDateTime deletedDate;

    // Relationships
    @ManyToOne
    @JoinColumn(
            name = "ClientId",
            foreignKey = @ForeignKey(name = "FK_ClientOrgType_Client"),
            insertable = false, updatable = false
    )
    private Client client;

    @ManyToOne
    @JoinColumn(
            name = "OrgTypeId",
            foreignKey = @ForeignKey(name = "FK_ClientOrgType_OrgType"),
            insertable = false, updatable = false
    )
    private OrgType orgType;

    @ManyToOne
    @JoinColumn(
            name = "TenantId",
            foreignKey = @ForeignKey(name = "FK_ClientOrgType_Tenant"),
            insertable = false, updatable = false
    )
    private Tenant tenant;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientSpecName() {
        return clientSpecName;
    }

    public void setClientSpecName(String clientSpecName) {
        this.clientSpecName = clientSpecName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrgType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrgType orgType) {
        this.orgType = orgType;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
