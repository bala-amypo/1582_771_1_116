// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(name = "contracts")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class Contract {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String contractNumber;

//     @Column(nullable = false)
//     private String title;

//     @Column(nullable = false)
//     private String counterpartyName;

//     @Column(nullable = false)
//     private LocalDate agreedDeliveryDate;

//     @Column(nullable = false)
//     private BigDecimal baseContractValue;

//     @Column(nullable = false)
//     private String status;

//     private LocalDateTime createdAt;
//     private LocalDateTime updatedAt;

//     /* ---------------- Relationships ---------------- */

//     @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
//     private List<DeliveryRecord> deliveryRecords;

//     @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
//     private List<PenaltyCalculation> penaltyCalculations;

//     @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
//     private List<BreachReport> breachReports;

//     /* ---------------- Lifecycle ---------------- */

//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         this.updatedAt = LocalDateTime.now();
//         if (this.status == null) {
//             this.status = "ACTIVE";
//         }
//     }

//     @PreUpdate
//     public void onUpdate() {
//         this.updatedAt = LocalDateTime.now();
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractNumber;
    private String title;
    private String counterpartyName; // ✅ added field
    private Double baseContractValue;
    private LocalDate agreedDeliveryDate;
    private String status;

    public Contract() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContractNumber() { return contractNumber; }
    public void setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCounterpartyName() { return counterpartyName; } // ✅ getter
    public void setCounterpartyName(String counterpartyName) { this.counterpartyName = counterpartyName; } // ✅ setter

    public Double getBaseContractValue() { return baseContractValue; }
    public void setBaseContractValue(Double baseContractValue) { this.baseContractValue = baseContractValue; }

    public LocalDate getAgreedDeliveryDate() { return agreedDeliveryDate; }
    public void setAgreedDeliveryDate(LocalDate agreedDeliveryDate) { this.agreedDeliveryDate = agreedDeliveryDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
