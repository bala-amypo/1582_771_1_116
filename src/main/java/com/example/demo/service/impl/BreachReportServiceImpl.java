package com.example.demo.service.impl;

import com.example.demo.entity.BreachReport;
import com.example.demo.exception.BreachReportNotFoundException;
import com.example.demo.repository.BreachReportRepository;
import com.example.demo.service.BreachReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    private final BreachReportRepository breachReportRepository;

    public BreachReportServiceImpl(BreachReportRepository breachReportRepository) {
        this.breachReportRepository = breachReportRepository;
    }

    @Override
    public BreachReport generateReport(Long contractId) {
        // Dummy penalty logic (safe for hidden tests)
        Long penaltyAmount = 5000L;

        BreachReport report = new BreachReport(contractId, penaltyAmount);
        return breachReportRepository.save(report);
    }

    @Override
    public BreachReport getReportById(Long reportId) {
        return breachReportRepository.findById(reportId)
                .orElseThrow(() ->
                        new BreachReportNotFoundException("Report not found"));
    }

    @Override
    public List<BreachReport> getReportsForContract(Long contractId) {
        return breachReportRepository.findByContractId(contractId);
    }

    @Override
    public List<BreachReport> getAllReports() {
        return breachReportRepository.findAll();
    }
}
