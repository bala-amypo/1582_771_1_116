package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class DeliveryRecord {
    @Id @GeneratedValue
    private long id;
    @ManyToOne
    private Contract contract;
    private Date deliveryDate;
    private String notes;
    private LocalDateTime createdAt;
    public DeliveryRecord(){

    }
    public DeliveryRecord(Contract contract, Date deliveryDate, String notes, LocalDateTime createdAt) {
        this.contract = contract;
        this.deliveryDate = deliveryDate;
        this.notes = notes;
        this.createdAt = createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public long getId() {
        return id;
    }
    public Contract getContract() {
        return contract;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public String getNotes() {
        return notes;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    


    
    

    




}
