package com.grantapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double personnelCost;
    private double fringeBenefit;
    private double equipmentCost;
    private double indirectCost;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPersonnelCost() {
        return personnelCost;
    }

    public void setPersonnelCost(double personnelCost) {
        this.personnelCost = personnelCost;
    }

    public double getFringeBenefit() {
        return fringeBenefit;
    }

    public void setFringeBenefit(double fringeBenefit) {
        this.fringeBenefit = fringeBenefit;
    }

    public double getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(double equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public double getIndirectCost() {
        return indirectCost;
    }

    public void setIndirectCost(double indirectCost) {
        this.indirectCost = indirectCost;
    }
}