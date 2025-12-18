package com.example.demo.controller;

import com.example.demo.service.PenaltyCalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penalties")
public class PenaltyCalculationController {

    private final PenaltyCalculationService penaltyService;

    public PenaltyCalculationController(PenaltyCalculationService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @PostMapping("/{contractId}")
    public String calculatePenalty(@PathVariable Long contractId) {

        penaltyService.calculatePenalty(contractId);

        return "Penalty calculated successfully";
    }
}
