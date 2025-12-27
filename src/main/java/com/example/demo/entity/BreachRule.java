// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;
// import java.util.List;

// @Entity
// @Table(name = "breach_rules")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class BreachRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String ruleName;

//     @Column(nullable = false)
//     private BigDecimal penaltyPerDay;

//     @Column(nullable = false)
//     private Double maxPenaltyPercentage;

//     private Boolean active;

//     private Boolean isDefaultRule;

//     /* ---------------- Relationships ---------------- */

//     @OneToMany(mappedBy = "breachRule", fetch = FetchType.LAZY)
//     private List<PenaltyCalculation> penaltyCalculations;

//     @PrePersist
//     public void onCreate() {
//         if (active == null) {
//             active = true;
//         }
//         if (isDefaultRule == null) {
//             isDefaultRule = false;
//         }
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private Double penaltyPerDay;
    private Double maxPenaltyPercentage;
    private Boolean active;
    private Boolean isDefaultRule;

    @OneToMany(mappedBy = "breachRule")
    private List<PenaltyCalculation> penaltyCalculations;

    // getters and setters
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

    public Boolean getIsDefaultRule() {
        return isDefaultRule;
    }

    public void setIsDefaultRule(Boolean isDefaultRule) {
        this.isDefaultRule = isDefaultRule;
    }

    public List<PenaltyCalculation> getPenaltyCalculations() {
        return penaltyCalculations;
    }

    public void setPenaltyCalculations(List<PenaltyCalculation> penaltyCalculations) {
        this.penaltyCalculations = penaltyCalculations;
    }
}
