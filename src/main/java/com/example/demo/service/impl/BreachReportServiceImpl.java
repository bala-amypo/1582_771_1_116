package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.BreachReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    @Autowired
    private BreachReportRepository breachReportRepository;

    @Autowired
    private PenaltyCalculationRepository penaltyCalculationRepository;

    @Autowired
    private ContractRepository contractRepository;

    // KEEP no-arg constructor (for tests)
    public BreachReportServiceImpl() {
    }

    @Override
    public BreachReport generateReport(Long contractId) {

        Contract c = contractRepository.findById(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        PenaltyCalculation pc = penaltyCalculationRepository
                .findTopByContractIdOrderByCalculatedAtDesc(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("No penalty calculation"));

        BreachReport report = BreachReport.builder()
                .contract(c)
                .daysDelayed(pc.getDaysDelayed())
                .penaltyAmount(pc.getCalculatedPenalty())
                .build();

        return breachReportRepository.save(report);
    }

    @Override
    public BreachReport getReportById(Long id) {
        return breachReportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));
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
