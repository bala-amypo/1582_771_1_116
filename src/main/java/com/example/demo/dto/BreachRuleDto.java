// package com.example.demo.dto;

// import lombok.Data;

// import java.math.BigDecimal;

// @Data
// public class BreachRuleDto {
//     private Long id;
//     private String ruleName;
//     private BigDecimal penaltyPerDay;
//     private Double maxPenaltyPercentage;
//     private Boolean active;
//     private Boolean isDefaultRule;
// }
package com.example.demo.dto;

public class BreachRuleDto {

    private Long id;
    private String ruleName;
    private Double penaltyPerDay;
    private Double maxPenaltyPercentage;
    private boolean active;
    private boolean defaultRule;

    public BreachRuleDto() {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDefaultRule() {
        return defaultRule;
    }

    public void setDefaultRule(boolean defaultRule) {
        this.defaultRule = defaultRule;
    }
}
