package com.grantapp.model.cars.application;

import com.grantapp.model.cars.lookup.ApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Application", schema = "cars", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"LogNumber"})
})
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "ApplicationStatusId",
            foreignKey = @ForeignKey(name = "FY_ApplicationStatus_Application"),
            insertable = false, updatable = false)
    private ApplicationStatus applicationStatus;

    @Column
    private LocalDateTime applicationStatusChangeDate;

    @Column(nullable = false, length = 12)
    private String logNumber;

    @Column(length = 500)
    private String applicationTitle;

    @Column(length = 200)
    private String researchArea;

    @Column(length = 1000)
    private String keywords;

    @Column
    private LocalDateTime projectStartDate;

    @Column
    private LocalDateTime projectEndDate;

    @Column(nullable = false)
    private boolean withdrawnFlag = false;

    @Column
    private Integer withdrawnBy;

    @Column
    private LocalDateTime withdrawnDate;

    @Column
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

    @Column(nullable = false)
    private boolean deletedFlag = false;

    @Column
    private Integer deletedBy;

    @Column
    private LocalDateTime deletedDate;

    @Column(nullable = false)
    private int tenantId = 1;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "ParentApplicationId",
            foreignKey = @ForeignKey(name = "FY_ParentApplication_Application"),
            insertable = false, updatable = false)
    private Application parentApplication;

    @ManyToOne
    @JoinColumn(name = "ProgramMechanismId",
            foreignKey = @ForeignKey(name = "FY_ProgramMechanism_Application"),
            insertable = false, updatable = false)
    private ProgramMechanism programMechanism;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getApplicationStatusChangeDate() {
        return applicationStatusChangeDate;
    }

    public void setApplicationStatusChangeDate(LocalDateTime applicationStatusChangeDate) {
        this.applicationStatusChangeDate = applicationStatusChangeDate;
    }

    public String getLogNumber() {
        return logNumber;
    }

    public void setLogNumber(String logNumber) {
        this.logNumber = logNumber;
    }

    public String getApplicationTitle() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public LocalDateTime getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(LocalDateTime projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public LocalDateTime getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(LocalDateTime projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public boolean isWithdrawnFlag() {
        return withdrawnFlag;
    }

    public void setWithdrawnFlag(boolean withdrawnFlag) {
        this.withdrawnFlag = withdrawnFlag;
    }

    public Integer getWithdrawnBy() {
        return withdrawnBy;
    }

    public void setWithdrawnBy(Integer withdrawnBy) {
        this.withdrawnBy = withdrawnBy;
    }

    public LocalDateTime getWithdrawnDate() {
        return withdrawnDate;
    }

    public void setWithdrawnDate(LocalDateTime withdrawnDate) {
        this.withdrawnDate = withdrawnDate;
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

    public Application getParentApplication() {
        return parentApplication;
    }

    public void setParentApplication(Application parentApplication) {
        this.parentApplication = parentApplication;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public ProgramMechanism getProgramMechanism() {
        return programMechanism;
    }

    public void setProgramMechanism(ProgramMechanism programMechanism) {
        this.programMechanism = programMechanism;
    }
}