package com.example.demo.controller;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/penalties")
@CrossOrigin("*")
public class PenaltyCalculationController {

    private final PenaltyCalculationService service;

    public PenaltyCalculationController(PenaltyCalculationService service) {
        this.service = service;
    }

    @PostMapping
    public PenaltyCalculation create(@RequestBody PenaltyCalculation pc) {
        return service.save(pc);
    }

    @GetMapping("/contract/{contractId}")
    public List<PenaltyCalculation> get(@PathVariable Long contractId) {
        return service.getByContract(contractId);
    }
}
