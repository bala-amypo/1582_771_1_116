package com.example.demo.dto;

import java.time.LocalDateTime;

public class DeliveryRecordDTO {

    private Long contractId;
    private LocalDateTime actualDeliveryDate;
    private String remarks;

    public DeliveryRecordDTO() {}

    public DeliveryRecordDTO(Long contractId, LocalDateTime actualDeliveryDate, String remarks) {
        this.contractId = contractId;
        this.actualDeliveryDate = actualDeliveryDate;
        this.remarks = remarks;
    }

    public Long getContractId() { return contractId; }
    public void setContractId(Long contractId) { this.contractId = contractId; }

    public LocalDateTime getActualDeliveryDate() { return actualDeliveryDate; }
    public void setActualDeliveryDate(LocalDateTime actualDeliveryDate) { this.actualDeliveryDate = actualDeliveryDate; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
