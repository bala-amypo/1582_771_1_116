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

@Entity
public class BreachRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private boolean active;

    public BreachRule() {}

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
 
    public boolean isActive() {
        return active;
    }
 
    public void setActive(boolean active) {
        this.active = active;
    }
}
