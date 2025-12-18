package com.example.demo.entity;

import java.math.BigDecimal;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BreachRule {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ruleName;
    private BigDecimal penaltyPerDay;
    private Double maxPenaltyPercentage;
    private Boolean active;
    private Boolean isDefaultRule;
    public BreachRule(){

    }
   
   
    public BreachRule(String ruleName, BigDecimal penaltyPerDay, Double maxPenaltyPercentage, Boolean active,
            Boolean isDefaultRule) {
        this.penaltyPerDay = penaltyPerDay;
        this.maxPenaltyPercentage = maxPenaltyPercentage;
        this.active = active;
        this.isDefaultRule = isDefaultRule;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public void setPenaltyPerDay(BigDecimal penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }
    public void setMaxPenaltyPercentage(Double maxPenaltyPercentage) {
        this.maxPenaltyPercentage = maxPenaltyPercentage;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public void setIsDefaultRule(Boolean isDefaultRule) {
        this.isDefaultRule = isDefaultRule;
    }
    public long getId() {
        return id;
    }
    public String getRuleName() {
        return ruleName;
    }
    public BigDecimal getPenaltyPerDay() {
        return penaltyPerDay;
    }
    public Double getMaxPenaltyPercentage() {
        return maxPenaltyPercentage;
    }
    public Boolean getActive() {
        return active;
    }
    public Boolean getIsDefaultRule() {
        return isDefaultRule;
    }
    


    

}
