package com.example.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.portal.entity.BreachReport;
import com.example.portal.service.BreachReportService;

public class BreachReportController {
    
     private final BreachReportService breachReportService;

    public BreachReportController(BreachReportService breachReportService) {
        this.breachReportService = breachReportService;
    }

    @PostMapping("/generate/{contractid}")
    public BreachReport generate(@PathVariable Long contractid) {
        return breachReportService.generateReport(contractid);
    }

    @GetMapping("/{id}")
    public BreachReport getById(@PathVariable Long id) {
        return breachReportService.getReportById(id);
    }

    @GetMapping("/contract/{contractid}")
    public List<BreachReport> getByContract(@PathVariable Long contractid) {
        return breachReportService.getReportsForContract(contractid);
    }

    @GetMapping
    public List<BreachReport> getAll() {
        return breachReportService.getAllReports();
    }
}
