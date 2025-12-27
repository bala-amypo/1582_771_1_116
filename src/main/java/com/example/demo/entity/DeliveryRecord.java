// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDate;

// @Entity
// @Table(name = "delivery_records")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class DeliveryRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "contract_id", nullable = false)
//     private Contract contract;

//     @Column(nullable = false)
//     private LocalDate deliveryDate;

//     private String notes;
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate deliveryDate;

    public DeliveryRecord() {}

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
 
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
