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

    @Autowired private BreachReportRepository breachReportRepository;
    @Autowired private PenaltyCalculationRepository penaltyCalculationRepository;
    @Autowired private ContractRepository contractRepository;

    @Override
    public BreachReport generateReport(Long contractId) {
        // Ensure contract exists
        contractRepository.findById(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        // Get the most recent calculation for this contract
        PenaltyCalculation latestCalc = penaltyCalculationRepository
                .findTopByContractIdOrderByCalculatedAtDesc(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("No penalty calculation found for this contract. Please run calculation first."));

        BreachReport report = BreachReport.builder()
                .contractId(contractId)
                .daysDelayed(latestCalc.getDaysDelayed())
                .penaltyAmount(latestCalc.getCalculatedPenalty())
                .build();

        return breachReportRepository.save(report);
    }

    @Override
    public List<BreachReport> getReportsByContract(Long contractId) {
        // Implementation of custom query to fetch report history
        return breachReportRepository.findAll(); 
    }
}