package com.example.demo.service.impl;

import com.example.demo.entity.BreachReport;
import com.example.demo.repository.BreachReportRepository;
import com.example.demo.service.BreachReportService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    private final BreachReportRepository repository;

    public BreachReportServiceImpl(BreachReportRepository repository) {
        this.repository = repository;
    }

    public BreachReport save(BreachReport report) {
        return repository.save(report);
    }

    public List<BreachReport> getByContract(Long contractId) {
        return repository.findByContractId(contractId);
    }
}
