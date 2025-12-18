package com.example.demo.controller;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/penalties")
public class PenaltyCalculationController {

    private final PenaltyCalculationService penaltyService;

    public PenaltyCalculationController(PenaltyCalculationService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @PostMapping("/{contractId}")
    public PenaltyCalculation calculatePenalty(@PathVariable Long contractId) {
        return penaltyService.calculatePenalty(contractId);
    }

    @GetMapping("/{id}")
    public PenaltyCalculation getPenalty(@PathVariable Long id) {
        return penaltyService.getPenaltyById(id);
    }

    @GetMapping("/contract/{contractId}")
    public List<PenaltyCalculation> getPenaltiesForContract(@PathVariable Long contractId) {
        return penaltyService.getPenaltiesForContract(contractId);
    }

    @GetMapping
    public List<PenaltyCalculation> getAllPenalties() {
        return penaltyService.getAllPenalties();
    }
}
