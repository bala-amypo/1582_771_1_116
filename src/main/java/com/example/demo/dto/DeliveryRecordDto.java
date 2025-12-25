package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRecordDto {
    private Long contractId;
    private LocalDate deliveryDate;
    private String notes;
}
