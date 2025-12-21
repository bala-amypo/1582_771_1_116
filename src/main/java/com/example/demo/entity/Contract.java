package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String contractNumber;

    private String title;
    private String counterpartyName;

    @Temporal(TemporalType.DATE)
    private Date agreedDeliveryDate;

    private BigDecimal baseContractValue;
    private String status;

    private Instant createdAt;
    private Instant updatedAt;

    public Contract() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Contract(String contractNumber, String title, String counterpartyName,
                    Date agreedDeliveryDate, BigDecimal baseContractValue, String status) {
        this.contractNumber = contractNumber;
        this.title = title;
        this.counterpartyName = counterpartyName;
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        this.status = status;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContractNumber() { return contractNumber; }
    public void setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCounterpartyName() { return counterpartyName; }
    public void setCounterpartyName(String counterpartyName) { this.counterpartyName = counterpartyName; }

    public Date getAgreedDeliveryDate() { return agreedDeliveryDate; }
    public void setAgreedDeliveryDate(Date agreedDeliveryDate) { this.agreedDeliveryDate = agreedDeliveryDate; }

    public BigDecimal getBaseContractValue() { return baseContractValue; }
    public void setBaseContractValue(BigDecimal baseContractValue) { this.baseContractValue = baseContractValue; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
