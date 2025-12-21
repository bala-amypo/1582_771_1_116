package com.example.demo.controller;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalties")
@CrossOrigin(origins = "*")
public class PenaltyCalculationController {

    private final PenaltyCalculationService penaltyService;

    public PenaltyCalculationController(PenaltyCalculationService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @PostMapping("/calculate/{contractId}")
    public PenaltyCalculation calculate(@PathVariable Long contractId) {
        return penaltyService.calculatePenalty(contractId);
    }

    @GetMapping("/{id}")
    public PenaltyCalculation getById(@PathVariable Long id) {
        return penaltyService.getCalculationById(id);
    }

    @GetMapping("/contract/{contractId}")
    public List<PenaltyCalculation> getByContract(@PathVariable Long contractId) {
        return penaltyService.getCalculationsForContract(contractId);
    }
}
