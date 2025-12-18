package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
@RestController
@RequestMapping("/api/penalties")
public class PenaltyCalculationController {
    private final PenaltyCalculationService penaltyCalculationService;

    public PenaltyCalculationController(PenaltyCalculationService penaltyCalculationService) {
        this.penaltyCalculationService = penaltyCalculationService;
    }

    @PostMapping("/calculate/{contractid}")
    public PenaltyCalculation calculate(@PathVariable Long contractid) {
        return penaltyCalculationService.calculatePenalty(contractid);
    }

    @GetMapping("/{id}")
    public PenaltyCalculation getById(@PathVariable Long id) {
        return penaltyCalculationService.getCalculationById(id);
    }

    @GetMapping("/contract/{contractid}")
    public List<PenaltyCalculation> getByContract(@PathVariable Long contractid) {
        return penaltyCalculationService.getCalculationsForContract(contractid);
    }
    
}
