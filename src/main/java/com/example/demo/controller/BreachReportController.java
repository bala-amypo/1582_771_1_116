package com.example.demo.controller;

import com.example.demo.entity.BreachReport;
import com.example.demo.entity.Contract;
import com.example.demo.repository.BreachReportRepository;
import com.example.demo.repository.ContractRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/breach-reports")
public class BreachReportController {

    private final BreachReportRepository breachReportRepository;
    private final ContractRepository contractRepository;

    public BreachReportController(
            BreachReportRepository breachReportRepository,
            ContractRepository contractRepository) {
        this.breachReportRepository = breachReportRepository;
        this.contractRepository = contractRepository;
    }

    @PostMapping
    public BreachReport createReport(
            @RequestParam Long contractId,
            @RequestParam int daysDelayed,
            @RequestParam String ruleName,
            @RequestParam String summary) {

        Contract contract = contractRepository.findById(contractId).orElse(null);

        if (contract == null) {
            return null; // NO exception as requested
        }

        BreachReport report = new BreachReport();
        report.setContract(contract);
        report.setDaysDelayed(daysDelayed);
        report.setRuleName(ruleName);
        report.setSummary(summary);

        return breachReportRepository.save(report);
    }
}
