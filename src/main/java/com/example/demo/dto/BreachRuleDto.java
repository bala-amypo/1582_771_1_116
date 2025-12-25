package com.example.demo.dto;

public class BreachRuleDTO {

    private Integer delayFromDays;
    private Integer delayToDays;
    private Double penaltyPercentage;
    private boolean active;
    private boolean defaultRule;

    public BreachRuleDTO() {}

    public BreachRuleDTO(Integer delayFromDays, Integer delayToDays,
                         Double penaltyPercentage, boolean active,
                         boolean defaultRule) {
        this.delayFromDays = delayFromDays;
        this.delayToDays = delayToDays;
        this.penaltyPercentage = penaltyPercentage;
        this.active = active;
        this.defaultRule = defaultRule;
    }

    public Integer getDelayFromDays() { return delayFromDays; }
    public void setDelayFromDays(Integer delayFromDays) { this.delayFromDays = delayFromDays; }

    public Integer getDelayToDays() { return delayToDays; }
    public void setDelayToDays(Integer delayToDays) { this.delayToDays = delayToDays; }

    public Double getPenaltyPercentage() { return penaltyPercentage; }
    public void setPenaltyPercentage(Double penaltyPercentage) { this.penaltyPercentage = penaltyPercentage; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean isDefaultRule() { return defaultRule; }
    public void setDefaultRule(boolean defaultRule) { this.defaultRule = defaultRule; }
}
