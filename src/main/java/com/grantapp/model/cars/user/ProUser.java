package com.grantapp.model.cars.user;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "pro_user", schema = "cars")
@EntityListeners(AuditingEntityListener.class) // Enable auditing
public class ProUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "UserLogin", length = 100)
    private String userLogin;

    @Column(name = "Password", length = 128)
    private String password;

    @Column(name = "PasswordDate")
    private LocalDateTime passwordDate;

    @Column(name = "PasswordSalt", length = 128)
    private String passwordSalt;

    @Column(name = "Verified")
    private Boolean verified;

    @Column(name = "VerifiedDate")
    private LocalDateTime verifiedDate;

    @Column(name = "IsActivated", nullable = false)
    private Boolean isActivated = false;

    @Column(name = "LastLoginDate", nullable = false)
    private LocalDateTime lastLoginDate;

    @Column(name = "IsLockedOut", nullable = false)
    private Boolean isLockedOut = false;

    @Column(name = "LastLockedOutDate", nullable = false)
    private LocalDateTime lastLockedOutDate;

    @Column(name = "NewPasswordRequested")
    private LocalDateTime newPasswordRequested;

    @Column(name = "NewEmail", length = 100)
    private String newEmail;

    @Column(name = "NewEmailRequested")
    private LocalDateTime newEmailRequested;

    @Column(name = "PersonID")
    private Integer personId;

    @Column(name = "CredentialSentBy")
    private Integer credentialSentBy;

    @Column(name = "CredentialSentDate")
    private LocalDateTime credentialSentDate;

    @Column(name = "W9Verified")
    private Boolean w9Verified;

    @Column(name = "W9VerifiedDate")
    private LocalDateTime w9VerifiedDate;

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
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @Column(name = "DeletedFlag", nullable = false)
    private Boolean deletedFlag = false;

    @Column(name = "DeletedBy")
    private Integer deletedBy;

    @Column(name = "DeletedDate")
    private LocalDateTime deletedDate;

    @Column(name = "TenantId", nullable = false)
    private Integer tenantId = 1;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getPasswordDate() {
        return passwordDate;
    }

    public void setPasswordDate(LocalDateTime passwordDate) {
        this.passwordDate = passwordDate;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public LocalDateTime getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(LocalDateTime verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public Boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(Boolean isActivated) {
        this.isActivated = isActivated;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Boolean getIsLockedOut() {
        return isLockedOut;
    }

    public void setIsLockedOut(Boolean isLockedOut) {
        this.isLockedOut = isLockedOut;
    }

    public LocalDateTime getLastLockedOutDate() {
        return lastLockedOutDate;
    }

    public void setLastLockedOutDate(LocalDateTime lastLockedOutDate) {
        this.lastLockedOutDate = lastLockedOutDate;
    }

    public LocalDateTime getNewPasswordRequested() {
        return newPasswordRequested;
    }

    public void setNewPasswordRequested(LocalDateTime newPasswordRequested) {
        this.newPasswordRequested = newPasswordRequested;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public LocalDateTime getNewEmailRequested() {
        return newEmailRequested;
    }

    public void setNewEmailRequested(LocalDateTime newEmailRequested) {
        this.newEmailRequested = newEmailRequested;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getCredentialSentBy() {
        return credentialSentBy;
    }

    public void setCredentialSentBy(Integer credentialSentBy) {
        this.credentialSentBy = credentialSentBy;
    }

    public LocalDateTime getCredentialSentDate() {
        return credentialSentDate;
    }

    public void setCredentialSentDate(LocalDateTime credentialSentDate) {
        this.credentialSentDate = credentialSentDate;
    }

    public Boolean getW9Verified() {
        return w9Verified;
    }

    public void setW9Verified(Boolean w9Verified) {
        this.w9Verified = w9Verified;
    }

    public LocalDateTime getW9VerifiedDate() {
        return w9VerifiedDate;
    }

    public void setW9VerifiedDate(LocalDateTime w9VerifiedDate) {
        this.w9VerifiedDate = w9VerifiedDate;
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

    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Boolean deletedFlag) {
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

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }
}