// package com.example.demo.dto;

// import lombok.Data;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;

// @Data
// public class BreachReportDto {
//     private Long id;
//     private Long contractId;
//     private Integer daysDelayed;
//     private BigDecimal penaltyAmount;
//     private String reportStatus;
//     private LocalDateTime generatedAt;
// }
package com.example.demo.dto;

import java.time.LocalDateTime;

public class BreachReportDto {

    private Long id;
    private Long contractId;
    private int daysDelayed;
    private Double penaltyAmount;
    private String reportStatus;
    private LocalDateTime generatedAt;

    public BreachReportDto() {
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

    public int getDaysDelayed() {
        return daysDelayed;
    }

    public void setDaysDelayed(int daysDelayed) {
        this.daysDelayed = daysDelayed;
    }

    public Double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
