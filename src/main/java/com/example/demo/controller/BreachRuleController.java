package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@CrossOrigin(origins = "*")
@Entity
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ruleName")
    private String ruleName;

    @JsonProperty("penaltyPerDay")
    private Double penaltyPerDay;

    @JsonProperty("maxPenaltyPercentage")
    private Double maxPenaltyPercentage;

    @JsonProperty("active")
    private Boolean active;

    // Constructors
    public BreachRule() {}

    public BreachRule(String ruleName, Double penaltyPerDay, Double maxPenaltyPercentage, Boolean active) {
        this.ruleName = ruleName;
        this.penaltyPerDay = penaltyPerDay;
        this.maxPenaltyPercentage = maxPenaltyPercentage;
        this.active = active;
    }

    // Getters and Setters
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

    public Double getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public void setPenaltyPerDay(Double penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }

    public Double getMaxPenaltyPercentage() {
        return maxPenaltyPercentage;
    }

    public void setMaxPenaltyPercentage(Double maxPenaltyPercentage) {
        this.maxPenaltyPercentage = maxPenaltyPercentage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
