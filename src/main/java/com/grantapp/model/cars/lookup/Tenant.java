package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Tenant", schema = "cars")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "TenantTypeId")
    private Integer tenantTypeId;

    @Column(name = "TenantName", nullable = false, length = 255)
    private String tenantName;

    @Column(name = "TenantGUID")
    private UUID tenantGUID;

    // Relationships
    @ManyToOne
    @JoinColumn(
            name = "TenantTypeId",
            foreignKey = @ForeignKey(name = "FK_Tenant_TenantType"),
            insertable = false, updatable = false
    )
    private TenantType tenantType;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTenantTypeId() {
        return tenantTypeId;
    }

    public void setTenantTypeId(Integer tenantTypeId) {
        this.tenantTypeId = tenantTypeId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public UUID getTenantGUID() {
        return tenantGUID;
    }

    public void setTenantGUID(UUID tenantGUID) {
        this.tenantGUID = tenantGUID;
    }

    public TenantType getTenantType() {
        return tenantType;
    }

    public void setTenantType(TenantType tenantType) {
        this.tenantType = tenantType;
    }
}