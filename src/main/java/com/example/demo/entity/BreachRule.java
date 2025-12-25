package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "breach_rules")
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer delayFromDays;
    private Integer delayToDays;
    private Double penaltyPercentage;
    private boolean active;
    private boolean isDefaultRule;

    public BreachRule() {}

    public BreachRule(Long id, Integer delayFromDays, Integer delayToDays,
                      Double penaltyPercentage, boolean active,
                      boolean isDefaultRule) {
        this.id = id;
        this.delayFromDays = delayFromDays;
        this.delayToDays = delayToDays;
        this.penaltyPercentage = penaltyPercentage;
        this.active = active;
        this.isDefaultRule = isDefaultRule;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getDelayFromDays() { return delayFromDays; }
    public void setDelayFromDays(Integer delayFromDays) { this.delayFromDays = delayFromDays; }

    public Integer getDelayToDays() { return delayToDays; }
    public void setDelayToDays(Integer delayToDays) { this.delayToDays = delayToDays; }

    public Double getPenaltyPercentage() { return penaltyPercentage; }
    public void setPenaltyPercentage(Double penaltyPercentage) { this.penaltyPercentage = penaltyPercentage; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean isDefaultRule() { return isDefaultRule; }
    public void setDefaultRule(boolean defaultRule) { isDefaultRule = defaultRule; }
}
