package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "breach_rules")
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private BigDecimal penaltyPerDay;
    private Double maxPenaltyPercentage;
    private boolean active;
    private boolean isDefaultRule;

    public BreachRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public BigDecimal getPenaltyPerDay() { return penaltyPerDay; }
    public void setPenaltyPerDay(BigDecimal penaltyPerDay) { this.penaltyPerDay = penaltyPerDay; }

    public Double getMaxPenaltyPercentage() { return maxPenaltyPercentage; }
    public void setMaxPenaltyPercentage(Double maxPenaltyPercentage) { this.maxPenaltyPercentage = maxPenaltyPercentage; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean isDefaultRule() { return isDefaultRule; }
    public void setDefaultRule(boolean defaultRule) { isDefaultRule = defaultRule; }
}
