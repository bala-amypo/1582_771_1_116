package com.example.demo.controller;

import com.example.demo.entity.BreachReport;
import com.example.demo.service.BreachReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class BreachReportController {

    @Autowired
    private BreachReportService breachReportService;

    @PostMapping("/generate/{contractId}")
    public BreachReport generateReport(@PathVariable Long contractId) {
        return breachReportService.generateReport(contractId);
    }

    @GetMapping("/{id}")
    public BreachReport getReportById(@PathVariable Long id) {
        return breachReportService.getReportById(id);
    }

    @GetMapping("/contract/{contractId}")
    public List<BreachReport> getReportsForContract(@PathVariable Long contractId) {
        return breachReportService.getReportsForContract(contractId);
    }

    @GetMapping
    public List<BreachReport> getAllReports() {
        return breachReportService.getAllReports();
    }
}
