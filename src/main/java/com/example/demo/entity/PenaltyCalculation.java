// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "penalty_calculations")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class PenaltyCalculation {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "contract_id", nullable = false)
//     private Contract contract;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "delivery_record_id")
//     private DeliveryRecord deliveryRecord;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "breach_rule_id", nullable = false)
//     private BreachRule breachRule;

//     @Column(nullable = false)
//     private Integer daysDelayed;

//     @Column(nullable = false)
//     private BigDecimal calculatedPenalty;

//     private LocalDateTime calculatedAt;

//     @PrePersist
//     public void onCreate() {
//         this.calculatedAt = LocalDateTime.now();
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PenaltyCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer daysDelayed;
    private Double calculatedPenalty;
    private LocalDateTime calculatedAt;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "delivery_record_id")
    private DeliveryRecord deliveryRecord;

    @ManyToOne
    @JoinColumn(name = "breach_rule_id")
    private BreachRule breachRule;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDaysDelayed() {
        return daysDelayed;
    }

    public void setDaysDelayed(Integer daysDelayed) {
        this.daysDelayed = daysDelayed;
    }

    public Double getCalculatedPenalty() {
        return calculatedPenalty;
    }

    public void setCalculatedPenalty(Double calculatedPenalty) {
        this.calculatedPenalty = calculatedPenalty;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public DeliveryRecord getDeliveryRecord() {
        return deliveryRecord;
    }

    public void setDeliveryRecord(DeliveryRecord deliveryRecord) {
        this.deliveryRecord = deliveryRecord;
    }

    public BreachRule getBreachRule() {
        return breachRule;
    }

    public void setBreachRule(BreachRule breachRule) {
        this.breachRule = breachRule;
    }
}
