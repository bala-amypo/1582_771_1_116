package com.example.demo.controller;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyCalculationController {

    @Autowired
    private PenaltyCalculationService penaltyCalculationService;

    @PostMapping("/calculate/{contractId}")
    public PenaltyCalculation calculatePenalty(@PathVariable Long contractId) {
        return penaltyCalculationService.calculatePenalty(contractId);
    }

    @GetMapping("/{id}")
    public PenaltyCalculation getCalculation(@PathVariable Long id) {
        return penaltyCalculationService.getCalculationById(id);
    }

    @GetMapping("/contract/{contractId}")
    public java.util.List<PenaltyCalculation> getCalculationsForContract(@PathVariable Long contractId) {
        return penaltyCalculationService.getCalculationsForContract(contractId);
    }
}
