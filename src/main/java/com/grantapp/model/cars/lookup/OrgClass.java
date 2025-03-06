package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;

@Entity
@Table(name = "OrgClass", schema = "cars")
public class OrgClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "OrgClassName", nullable = false, length = 50)
    private String orgClassName;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgClassName() {
        return orgClassName;
    }

    public void setOrgClassName(String orgClassName) {
        this.orgClassName = orgClassName;
    }
}