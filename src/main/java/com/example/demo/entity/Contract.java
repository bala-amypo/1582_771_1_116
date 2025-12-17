package com.example.demo.entity;

import java.math.BigDecimal;
import java.security.Timestamp;

public class Contract {
    private long id;
    private String contractpartyName;
    private String agreedDeliveryDate;
    private BigDecimal baseContractValue;
    private String Status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    public Contract(String contractpartyName, String agreedDeliveryDate, BigDecimal baseContractValue, String status,
            Timestamp createdAt, Timestamp updatedAt) {
        this.contractpartyName = contractpartyName;
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        Status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setContractpartyName(String contractpartyName) {
        this.contractpartyName = contractpartyName;
    }
    public void setAgreedDeliveryDate(String agreedDeliveryDate) {
        this.agreedDeliveryDate = agreedDeliveryDate;
    }
    public void setBaseContractValue(BigDecimal baseContractValue) {
        this.baseContractValue = baseContractValue;
    }
    public void setStatus(String status) {
        Status = status;
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
    public String getContractpartyName() {
        return contractpartyName;
    }
    public String getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }
    public BigDecimal getBaseContractValue() {
        return baseContractValue;
    }
    public String getStatus() {
        return Status;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
      
}
