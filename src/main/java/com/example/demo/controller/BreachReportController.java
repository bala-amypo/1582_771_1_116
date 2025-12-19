package com.example.demo.controller;

import com.example.demo.entity.BreachReport;
import com.example.demo.service.BreachReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breach-reports")
@CrossOrigin(origins = "*")
public class BreachReportController {

    private final BreachReportService service;

    public BreachReportController(
            BreachReportService service) {
        this.service = service;
    }

    @PostMapping
    public BreachReport create(
            @RequestBody BreachReport report) {
        return service.save(report);
    }

    @GetMapping
    public List<BreachReport> getAll() {
        return service.getAll();
    }
}
