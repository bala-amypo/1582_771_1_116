package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "breach_report")
public class BreachReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long contractId;
    private Integer daysDelayed;
    private BigDecimal penaltyAmount;

    public BreachReport() {
    }

    public Long getId() {
        return id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getDaysDelayed() {
        return daysDelayed;
    }

    public void setDaysDelayed(Integer daysDelayed) {
        this.daysDelayed = daysDelayed;
    }

    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }
}
