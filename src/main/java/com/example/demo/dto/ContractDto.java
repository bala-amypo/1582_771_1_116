// package com.example.demo.dto;

// import lombok.Data;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.time.LocalDateTime;

// @Data
// public class ContractDto {
//     private Long id;
//     private String contractNumber;
//     private String title;
//     private String counterpartyName;
//     private LocalDate agreedDeliveryDate;
//     private BigDecimal baseContractValue;
//     private String status;
//     private LocalDateTime createdAt;
// }
package com.example.demo.dto;

import java.time.LocalDate;

public class ContractDto {

    private Long id;
    private String contractNumber;
    private String title;
    private String counterpartyName;
    private LocalDate agreedDeliveryDate;
    private Double baseContractValue;
    private String status;

    public ContractDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCounterpartyName() {
        return counterpartyName;
    }

    public void setCounterpartyName(String counterpartyName) {
        this.counterpartyName = counterpartyName;
    }

    public LocalDate getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }

    public void setAgreedDeliveryDate(LocalDate agreedDeliveryDate) {
        this.agreedDeliveryDate = agreedDeliveryDate;
    }

    public Double getBaseContractValue() {
        return baseContractValue;
    }

    public void setBaseContractValue(Double baseContractValue) {
        this.baseContractValue = baseContractValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
