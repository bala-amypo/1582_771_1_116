// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "breach_reports")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class BreachReport {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "contract_id", nullable = false)
//     private Contract contract;

//     @Column(nullable = false)
//     private Integer daysDelayed;

//     @Column(nullable = false)
//     private BigDecimal penaltyAmount;

//     private String reportStatus;

//     private LocalDateTime generatedAt;

//     @PrePersist
//     public void onCreate() {
//         this.generatedAt = LocalDateTime.now();
//         if (this.reportStatus == null) {
//             this.reportStatus = "GENERATED";
//         }
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BreachReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer daysDelayed;
    private Double penaltyAmount;
    private String reportStatus;
    private LocalDateTime generatedAt;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
