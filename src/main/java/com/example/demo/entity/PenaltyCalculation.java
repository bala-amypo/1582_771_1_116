package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "penalty_calculation")
public class PenaltyCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long contractId;
    private Integer daysDelayed;
    private Double calculatedPenalty;

    public PenaltyCalculation() {}

    public Long getId() { return id; }
    public Long getContractId() { return contractId; }
    public void setContractId(Long contractId) { this.contractId = contractId; }
    public Integer getDaysDelayed() { return daysDelayed; }
    public void setDaysDelayed(Integer daysDelayed) { this.daysDelayed = daysDelayed; }
    public Double getCalculatedPenalty() { return calculatedPenalty; }
    public void setCalculatedPenalty(Double calculatedPenalty) { this.calculatedPenalty = calculatedPenalty; }
}
