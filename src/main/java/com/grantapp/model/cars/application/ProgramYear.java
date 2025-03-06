package com.grantapp.model.cars.application;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ProgramYear", schema = "cars", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ClientProgramId", "Year", "DeletedDate"})
})
public class ProgramYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "LegacyProgramId")
    private Integer legacyProgramId;

    @Column(name = "Year", nullable = false, length = 8)
    private String year;

    @Column(name = "DateClosed")
    private LocalDateTime dateClosed;

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
    @JoinColumn(name = "ClientProgramId",
            foreignKey = @ForeignKey(name = "FY_ClientProgram_ProgramYear"),
            insertable = false, updatable = false)
    private ClientProgram clientProgram;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLegacyProgramId() {
        return legacyProgramId;
    }

    public void setLegacyProgramId(Integer legacyProgramId) {
        this.legacyProgramId = legacyProgramId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDateTime getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
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

    public ClientProgram getClientProgram() {
        return clientProgram;
    }

    public void setClientProgram(ClientProgram clientProgram) {
        this.clientProgram = clientProgram;
    }
}