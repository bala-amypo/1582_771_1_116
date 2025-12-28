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
    BreachReportService breachReportService;

    @PostMapping("/generate/{contractId}")
    public BreachReport generate(@PathVariable Long contractId) {
        return breachReportService.generateReport(contractId);
    }

    @GetMapping
    public List<BreachReport> list() {
        return breachReportService.getAllReports();
    }
}
