package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "breach_rule")
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String description;

    private boolean active;

    private boolean isDefaultRule;

    private double penaltyPerDay;

    public BreachRule() {
    }

    public BreachRule(Long id, String ruleName, String description,
                      boolean active, boolean isDefaultRule,
                      double penaltyPerDay) {
        this.id = id;
        this.ruleName = ruleName;
        this.description = description;
        this.active = active;
        this.isDefaultRule = isDefaultRule;
        this.penaltyPerDay = penaltyPerDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public void setPenaltyPerDay(double penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }
}
