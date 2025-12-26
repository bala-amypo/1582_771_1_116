package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreachRuleDto {

    private Long id;

    @NotBlank(message = "Rule name is required")
    private String ruleName;

    @NotNull(message = "Penalty percentage is required")
    private BigDecimal penaltyPercentage;

    private String description;
}
