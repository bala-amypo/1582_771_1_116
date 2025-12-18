package com.example.demo.entity;

import java.math.BigDecimal;
import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class BreachReport {
    @Id @GeneratedValue
    private long id;
    private Contract contract;
    private Timestamp reportGeneratedAt;
    private int daysDelayed;
    private BigDecimal penaltyAmount;
    private String remarks;
    public BreachReport(){

    }


    BreachReport report = new BreachReport(contract  LocalDateTime.now(), 
                                       daysDelayed, 
                                       penalty, 
                                       appliedRule.getName());
 {
        this.contract = contract;
        this.reportGeneratedAt = reportGeneratedAt;
        this.daysDelayed = daysDelayed;
        this.penaltyAmount = penaltyAmount;
        this.remarks = remarks;
    }


    public void setId(long id) {
        this.id = id;
    }


    public void setContract(Contract contract) {
        this.contract = contract;
    }


    public void setReportGeneratedAt(Timestamp reportGeneratedAt) {
        this.reportGeneratedAt = reportGeneratedAt;
    }


    public void setDaysDelayed(int daysDelayed) {
        this.daysDelayed = daysDelayed;
    }


    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }


    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public long getId() {
        return id;
    }


    public Contract getContract() {
        return contract;
    }


    public Timestamp getReportGeneratedAt() {
        return reportGeneratedAt;
    }


    public int getDaysDelayed() {
        return daysDelayed;
    }


    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }


    public String getRemarks() {
        return remarks;
    }

    
}
