package com.example.demo.entity;

import java.math.BigDecimal;
import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PenaltyCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private int daysDelayed;

    private BigDecimal calculatedPenalty;
    private Timestamp calculatedAt;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BreachRule appliedRule;

    public PenaltyCalculation() {
    }

   

    public PenaltyCalculation(Contract contract, int daysDelayed, BigDecimal calculatePenalty, BreachRule appliedRule,
            Timestamp calculatedAt) {
        this.contract = contract;
        this.daysDelayed = daysDelayed;
        this.calculatedPenalty = calculatePenalty;
        this.appliedRule = appliedRule;
        this.calculatedAt = calculatedAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public void setDaysDelayed(int daysDelayed) {
        this.daysDelayed = daysDelayed;
    }
    public void setCalculatePenalty(BigDecimal calculatePenalty) {
        this.calculatedPenalty = calculatePenalty;
    }
    public void setAppliedRule(BreachRule appliedRule) {
        this.appliedRule = appliedRule;
    }
    public void setCalculatedAt(Timestamp calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
    public long getId() {
        return id;
    }
    public Contract getContract() {
        return contract;
    }
    public int getDaysDelayed() {
        return daysDelayed;
    }
    public BigDecimal getCalculatePenalty() {
        return calculatedPenalty;
    }
    public BreachRule getAppliedRule() {
        return appliedRule;
    }
    public Timestamp getCalculatedAt() {
        return calculatedAt;
    }
    
 
}
