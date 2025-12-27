// package com.example.demo.dto;

// import lombok.Data;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;

// @Data
// public class PenaltyCalculationDto {
//     private Long id;
//     private Long contractId;
//     private Integer daysDelayed;
//     private BigDecimal calculatedPenalty;
//     private LocalDateTime calculatedAt;
// }
package com.example.demo.dto;

import java.time.LocalDateTime;

public class PenaltyCalculationDto {

    private Long id;
    private Long contractId;
    private Long deliveryRecordId;
    private Long breachRuleId;
    private int daysDelayed;
    private Double calculatedPenalty;
    private LocalDateTime calculatedAt;

    public PenaltyCalculationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getDeliveryRecordId() {
        return deliveryRecordId;
    }

    public void setDeliveryRecordId(Long deliveryRecordId) {
        this.deliveryRecordId = deliveryRecordId;
    }

    public Long getBreachRuleId() {
        return breachRuleId;
    }

    public void setBreachRuleId(Long breachRuleId) {
        this.breachRuleId = breachRuleId;
    }

    public int getDaysDelayed() {
        return daysDelayed;
    }

    public void setDaysDelayed(int daysDelayed) {
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
}
