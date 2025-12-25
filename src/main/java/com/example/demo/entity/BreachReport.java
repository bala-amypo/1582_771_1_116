package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breach_reports")
public class BreachReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private Integer totalDelayDays;
    private Double totalPenalty;
    private LocalDateTime generatedAt;

    public BreachReport() {}

    public BreachReport(Long id, Contract contract, Integer totalDelayDays,
                        Double totalPenalty, LocalDateTime generatedAt) {
        this.id = id;
        this.contract = contract;
        this.totalDelayDays = totalDelayDays;
        this.totalPenalty = totalPenalty;
        this.generatedAt = generatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Contract getContract() { return contract; }
    public void setContract(Contract contract) { this.contract = contract; }

    public Integer getTotalDelayDays() { return totalDelayDays; }
    public void setTotalDelayDays(Integer totalDelayDays) { this.totalDelayDays = totalDelayDays; }

    public Double getTotalPenalty() { return totalPenalty; }
    public void setTotalPenalty(Double totalPenalty) { this.totalPenalty = totalPenalty; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}
