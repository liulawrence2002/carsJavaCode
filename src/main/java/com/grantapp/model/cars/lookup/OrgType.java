package com.grantapp.model.cars.lookup;

import jakarta.persistence.*;

@Entity
@Table(name = "OrgType", schema = "cars")
public class OrgType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "OrgTypeName", nullable = false, length = 50)
    private String orgTypeName;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }
}