package com.example.demo.entity;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name = "contracts", uniqueConstraints = @UniqueConstraint(columnNames = "contractNumber"))
public class Contract {
    @Id @GeneratedValue
    private long id;
    private String contractNumber;
    private String title;
    private String counterpartyName;
    private Date agreedDeliveryDate;
    private BigDecimal baseContractValue;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Contract(){

    }
    public Contract(String contractNumber, String title, String counterpartyName, Date agreedDeliveryDate,
            BigDecimal baseContractValue, String status, Timestamp createdAt, Timestamp updatedAt) {
        this.title = title;
        this.counterpartyName = counterpartyName;
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public void setId(long id) {
        this.id = id;
    }


    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setCounterpartyName(String counterpartyName) {
        this.counterpartyName = counterpartyName;
    }


    public void setAgreedDeliveryDate(Date agreedDeliveryDate) {
        this.agreedDeliveryDate = agreedDeliveryDate;
    }


    public void setBaseContractValue(BigDecimal baseContractValue) {
        this.baseContractValue = baseContractValue;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    public long getId() {
        return id;
    }


    public String getContractNumber() {
        return contractNumber;
    }


    public String getTitle() {
        return title;
    }


    public String getCounterpartyName() {
        return counterpartyName;
    }


    public Date getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }


    public BigDecimal getBaseContractValue() {
        return baseContractValue;
    }


    public String getStatus() {
        return status;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }


    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    
}
