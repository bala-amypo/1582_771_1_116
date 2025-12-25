package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "penalty_calculations")
public class PenaltyCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private Integer delayDays;
    private Double penaltyAmount;
    private LocalDateTime calculatedAt;

    public PenaltyCalculation() {}

    public PenaltyCalculation(Long id, Contract contract, Integer delayDays,
                              Double penaltyAmount, LocalDateTime calculatedAt) {
        this.id = id;
        this.contract = contract;
        this.delayDays = delayDays;
        this.penaltyAmount = penaltyAmount;
        this.calculatedAt = calculatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Contract getContract() { return contract; }
    public void setContract(Contract contract) { this.contract = contract; }

    public Integer getDelayDays() { return delayDays; }
    public void setDelayDays(Integer delayDays) { this.delayDays = delayDays; }

    public Double getPenaltyAmount() { return penaltyAmount; }
    public void setPenaltyAmount(Double penaltyAmount) { this.penaltyAmount = penaltyAmount; }

    public LocalDateTime getCalculatedAt() { return calculatedAt; }
    public void setCalculatedAt(LocalDateTime calculatedAt) { this.calculatedAt = calculatedAt; }
}
