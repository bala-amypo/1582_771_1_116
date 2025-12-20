package com.example.demo.controller;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyCalculationController {

    private final PenaltyCalculationService service;

    public PenaltyCalculationController(PenaltyCalculationService service) {
        this.service = service;
    }

    @PostMapping("/calculate/{contractId}")
    public double calculate(@PathVariable Long contractId) {
        return service.calculatePenalty(10); // example
    }

    @GetMapping("/{id}")
    public double getCalculation(@PathVariable Long id) {
        return 0;
    }

    @GetMapping("/contract/{contractId}")
    public String listCalculations(@PathVariable Long contractId) {
        return "list";
    }
}
