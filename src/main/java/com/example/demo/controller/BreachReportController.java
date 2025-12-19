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

    // POST /api/reports/generate/{contractId}
    @PostMapping("/generate/{contractId}")
    public BreachReport generate(@PathVariable Long contractId) {
        return reportService.generateReport(contractId);
    }

    // GET /api/reports/{id}
    @GetMapping("/{id}")
    public BreachReport get(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    // GET /api/reports/contract/{contractId}
    @GetMapping("/contract/{contractId}")
    public List<BreachReport> getByContract(@PathVariable Long contractId) {
        return reportService.getReportsForContract(contractId);
    }

    // GET /api/reports
    @GetMapping
    public List<BreachReport> getAll() {
        return reportService.getAllReports();
    }
}
