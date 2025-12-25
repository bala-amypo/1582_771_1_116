package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractNumber;
    private String title;
    private String counterpartyName;
    private LocalDateTime agreedDeliveryDate;
    private Double baseContractValue;
    private String status;
    private LocalDateTime createdAt;

    // Default constructor
    public Contract() {}

    // All-args constructor
    public Contract(Long id, String contractNumber, String title,
                    String counterpartyName, LocalDateTime agreedDeliveryDate,
                    Double baseContractValue, String status,
                    LocalDateTime createdAt) {
        this.id = id;
        this.contractNumber = contractNumber;
        this.title = title;
        this.counterpartyName = counterpartyName;
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContractNumber() { return contractNumber; }
    public void setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCounterpartyName() { return counterpartyName; }
    public void setCounterpartyName(String counterpartyName) { this.counterpartyName = counterpartyName; }

    public LocalDateTime getAgreedDeliveryDate() { return agreedDeliveryDate; }
    public void setAgreedDeliveryDate(LocalDateTime agreedDeliveryDate) { this.agreedDeliveryDate = agreedDeliveryDate; }

    public Double getBaseContractValue() { return baseContractValue; }
    public void setBaseContractValue(Double baseContractValue) { this.baseContractValue = baseContractValue; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
