package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRecordDto {

    private Long id;

    @NotNull(message = "Contract ID is required")
    private Long contractId;

    @NotNull(message = "Delivery date is required")
    private LocalDate deliveryDate;

    private String deliveryStatus;
}
