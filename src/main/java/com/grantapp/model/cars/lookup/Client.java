package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;

@Entity
@Table(name = "Client", schema = "cars")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "ClientAbrv", nullable = false, length = 10)
    private String clientAbrv;

    @Column(name = "ClientDesc", nullable = false, length = 100)
    private String clientDesc;

    @Column(name = "ClientHostDomain", nullable = false, length = 1024)
    private String clientHostDomain;

    @Column(name = "ClientHostSubdomain", length = 1024)
    private String clientHostSubdomain;

    @Column(name = "ClientHostPort")
    private Integer clientHostPort;

    @Column(name = "TenantId", nullable = false)
    private int tenantId = 1;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientAbrv() {
        return clientAbrv;
    }

    public void setClientAbrv(String clientAbrv) {
        this.clientAbrv = clientAbrv;
    }

    public String getClientDesc() {
        return clientDesc;
    }

    public void setClientDesc(String clientDesc) {
        this.clientDesc = clientDesc;
    }

    public String getClientHostDomain() {
        return clientHostDomain;
    }

    public void setClientHostDomain(String clientHostDomain) {
        this.clientHostDomain = clientHostDomain;
    }

    public String getClientHostSubdomain() {
        return clientHostSubdomain;
    }

    public void setClientHostSubdomain(String clientHostSubdomain) {
        this.clientHostSubdomain = clientHostSubdomain;
    }

    public Integer getClientHostPort() {
        return clientHostPort;
    }

    public void setClientHostPort(Integer clientHostPort) {
        this.clientHostPort = clientHostPort;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }
}