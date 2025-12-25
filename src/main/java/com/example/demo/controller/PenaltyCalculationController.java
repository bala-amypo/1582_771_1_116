package com.example.demo.controller;

import com.example.demo.entity.BreachReport;
import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.BreachReportService;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/process")
public class PenaltyCalculationController {

    @Autowired
    private PenaltyCalculationService penaltyService;

    @Autowired
    private BreachReportService reportService;

    @PostMapping("/calculate/{contractId}")
    public ResponseEntity<PenaltyCalculation> runCalculation(@PathVariable Long contractId) {
        return ResponseEntity.ok(penaltyService.calculatePenalty(contractId));
    }

    @GetMapping("/report/{contractId}")
    public ResponseEntity<BreachReport> generateReport(@PathVariable Long contractId) {
        return ResponseEntity.ok(reportService.generateReport(contractId));
    }
}