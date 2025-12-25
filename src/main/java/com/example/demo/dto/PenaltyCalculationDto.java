package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyCalculationDto {

    private Long id;
    private Long contractId;
    private BigDecimal penaltyAmount;
    private String reason;
}
