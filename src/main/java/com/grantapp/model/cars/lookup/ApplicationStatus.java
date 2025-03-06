package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;

@Entity
@Table(name = "ApplicationStatus", schema = "cars")
public class ApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "ApplicationStatusName", nullable = false, length = 20)
    private String applicationStatusName;

    @Column(name = "ApplicationStatusDescription", length = 10)
    private String applicationStatusDescription;

    @Column(name = "Active", nullable = false)
    private boolean active = false;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplicationStatusName() {
        return applicationStatusName;
    }

    public void setApplicationStatusName(String applicationStatusName) {
        this.applicationStatusName = applicationStatusName;
    }

    public String getApplicationStatusDescription() {
        return applicationStatusDescription;
    }

    public void setApplicationStatusDescription(String applicationStatusDescription) {
        this.applicationStatusDescription = applicationStatusDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}