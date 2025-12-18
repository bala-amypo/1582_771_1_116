package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class BreachReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private LocalDateTime timestamp;

    private int daysDelayed;

    private BigDecimal penalty;

    private String ruleName;

    // ✅ No-args constructor (REQUIRED by JPA)
    public BreachReport() {
    }

    // ✅ Correct constructor (matches service usage)
    public BreachReport(
            Contract contract,
            LocalDateTime timestamp,
            int daysDelayed,
            BigDecimal penalty,
            String ruleName
    ) {
        this.contract = contract;
        this.timestamp = timestamp;
        this.daysDelayed = daysDelayed;
        this.penalty = penalty;
        this.ruleName = ruleName;
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getDaysDelayed() {
        return daysDelayed;
    }

    public void setDaysDelayed(int daysDelayed) {
        this.daysDelayed = daysDelayed;
    }

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
