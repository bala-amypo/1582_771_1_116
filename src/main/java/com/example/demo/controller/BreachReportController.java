package com.example.demo.controller;

import com.example.demo.entity.BreachReport;
import com.example.demo.service.BreachReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class BreachReportController {

    private final BreachReportService breachReportService;

    public BreachReportController(BreachReportService breachReportService) {
        this.breachReportService = breachReportService;
    }

    // GET /api/reports
    @GetMapping
    public List<BreachReport> list() {
        return breachReportService.getAllReports();
    }

    // GET /api/reports/{id}
    @GetMapping("/{id}")
    public BreachReport getById(@PathVariable Long id) {
        return breachReportService.getReportById(id);
    }
}
