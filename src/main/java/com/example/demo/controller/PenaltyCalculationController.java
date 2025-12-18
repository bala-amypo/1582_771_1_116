package com.example.demo.controller;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/penalty-calculations")
public class PenaltyCalculationController {

    private final PenaltyCalculationService service;

    public PenaltyCalculationController(PenaltyCalculationService service) {
        this.service = service;
    }

    @PostMapping
    public PenaltyCalculation create(@RequestBody PenaltyCalculation calculation) {
        return service.save(calculation);
    }

    @GetMapping("/contract/{id}")
    public List<PenaltyCalculation> getByContract(@PathVariable Long id) {
        return service.getByContract(id);
    }
}
