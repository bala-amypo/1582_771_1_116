package com.example.demo.controller;

import com.example.demo.entity.BreachReport;
import com.example.demo.service.BreachReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class BreachReportController {

    private final BreachReportService reportService;

    public BreachReportController(BreachReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/generate/{contractId}")
    public BreachReport generate(@PathVariable Long contractId) {
        return reportService.generateReport(contractId);
    }

    @GetMapping("/{id}")
    public BreachReport get(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @GetMapping("/contract/{contractId}")
    public List<BreachReport> getByContract(@PathVariable Long contractId) {
        return reportService.getReportsForContract(contractId);
    }

   
    @GetMapping
    public List<BreachReport> getAll() {
        return reportService.getAllReports();
    }
}
