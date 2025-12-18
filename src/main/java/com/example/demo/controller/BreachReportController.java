package com.example.demo.controller;

import com.example.demo.entity.BreachReport;
import com.example.demo.service.BreachReportService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/breach-reports")
public class BreachReportController {

    private final BreachReportService service;

    public BreachReportController(BreachReportService service) {
        this.service = service;
    }

    @PostMapping
    public BreachReport create(@RequestBody BreachReport report) {
        return service.save(report);
    }

    @GetMapping("/contract/{id}")
    public List<BreachReport> getByContract(@PathVariable Long id) {
        return service.getByContract(id);
    }
}
