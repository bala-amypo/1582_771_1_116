package com.example.demo.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyCalculationDto {
    private Long contractId;
    private Integer daysDelayed;
    private BigDecimal calculatedPenalty;
    private LocalDateTime calculatedAt;
}
