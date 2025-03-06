package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;

@Entity
@Table(name = "TenantType", schema = "cars")
public class TenantType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "TenantTypeName", nullable = false, length = 255)
    private String tenantTypeName;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenantTypeName() {
        return tenantTypeName;
    }

    public void setTenantTypeName(String tenantTypeName) {
        this.tenantTypeName = tenantTypeName;
    }
}