package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String contractNumber;

    private String title;
    private String counterpartyName;
    private LocalDate agreedDeliveryDate;
    private Double baseContractValue;
    private String status = "ACTIVE";

    public Contract() {}

    public Long getId() { return id; }
    public String getContractNumber() { return contractNumber; }
    public void setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCounterpartyName() { return counterpartyName; }
    public void setCounterpartyName(String counterpartyName) { this.counterpartyName = counterpartyName; }
    public LocalDate getAgreedDeliveryDate() { return agreedDeliveryDate; }
    public void setAgreedDeliveryDate(LocalDate agreedDeliveryDate) { this.agreedDeliveryDate = agreedDeliveryDate; }
    public Double getBaseContractValue() { return baseContractValue; }
    public void setBaseContractValue(Double baseContractValue) { this.baseContractValue = baseContractValue; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
