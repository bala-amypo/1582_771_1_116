package com.example.demo.service.impl;

import com.example.demo.entity.BreachReport;
import com.example.demo.entity.BreachRule;
import com.example.demo.entity.Contract;
import com.example.demo.repository.BreachReportRepository;
import com.example.demo.service.BreachReportService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    private final BreachReportRepository breachReportRepository;

    public BreachReportServiceImpl(BreachReportRepository breachReportRepository) {
        this.breachReportRepository = breachReportRepository;
    }

    @Override
    public BreachReport createReport(
            Contract contract,
            int daysDelayed,
            BigDecimal penalty,
            BreachRule appliedRule
    ) {

        // ✅ Correct constructor usage (NO Long, Long)
        BreachReport report = new BreachReport(
                contract,
                LocalDateTime.now(),
                daysDelayed,
                penalty,
                appliedRule.getName()
        );

        return breachReportRepository.save(report);
    }

    @Override
    public BreachReport getReportById(Long id) {
        return breachReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Breach report not found"));
    }

    @Override
    public List<BreachReport> getAllReports() {
        return breachReportRepository.findAll();
    }
}
