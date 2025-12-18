package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double penaltyPerDayPercentage;
    private double maxPenaltyPercentage;
    private boolean active;
    private boolean isDefaultRule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {   // ✅ REQUIRED
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPenaltyPerDayPercentage() {
        return penaltyPerDayPercentage;
    }

    public void setPenaltyPerDayPercentage(double penaltyPerDayPercentage) {
        this.penaltyPerDayPercentage = penaltyPerDayPercentage;
    }

    public double getMaxPenaltyPercentage() {
        return maxPenaltyPercentage;
    }

    public void setMaxPenaltyPercentage(double maxPenaltyPercentage) {
        this.maxPenaltyPercentage = maxPenaltyPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDefaultRule() {
        return isDefaultRule;
    }

    public void setDefaultRule(boolean defaultRule) {
        isDefaultRule = defaultRule;
    }
}
