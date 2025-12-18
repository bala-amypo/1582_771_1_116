package com.example.demo.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")
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
