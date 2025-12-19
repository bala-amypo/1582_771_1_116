package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Contract contract;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    private String notes;

    // ✅ Default constructor
    public DeliveryRecord() {}

    // ✅ Parameterized constructor
    public DeliveryRecord(Contract contract, Date deliveryDate, String notes) {
        this.contract = contract;
        this.deliveryDate = deliveryDate;
        this.notes = notes;
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Contract getContract() { return contract; }
    public void setContract(Contract contract) { this.contract = contract; }

    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
