package com.example.demo.service.impl;

import com.example.demo.entity.BreachReport;
import com.example.demo.exception.ResourceNotFoundException;
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
    public BreachReport createBreachReport(BreachReport breachReport) {
        return breachReportRepository.save(breachReport);
    }

    @Override
    public BreachReport getBreachReportById(Long id) {
        return breachReportRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("BreachReport not found with id: " + id));
    }

    @Override
    public List<BreachReport> getAllBreachReports() {
        return breachReportRepository.findAll();
    }
}
