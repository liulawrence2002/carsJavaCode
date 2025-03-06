package com.grantapp.model.cars.user;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.grantapp.model.cars.lookup.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserOrganization", schema = "cars")
public class UserOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserInfoId", foreignKey = @ForeignKey(name = "FK_UserOrganization_UserInfo"), nullable = false)
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "UserOrgId", foreignKey = @ForeignKey(name = "FK_UserOrganization_Organization"), nullable = false)
    private Organization userOrg;

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
    @JoinColumn(name = "TenantId", foreignKey = @ForeignKey(name = "FK_UserOrganization_Tenant"), nullable = false)
    private Tenant tenant;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Organization getUserOrg() {
        return userOrg;
    }

    public void setUserOrg(Organization userOrg) {
        this.userOrg = userOrg;
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