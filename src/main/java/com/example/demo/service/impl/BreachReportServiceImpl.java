package com.example.demo.service.impl;

import com.example.demo.entity.BreachReport;
import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BreachReportRepository;
import com.example.demo.repository.PenaltyCalculationRepository;
import com.example.demo.service.BreachReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    @Autowired private BreachReportRepository breachReportRepository;
    @Autowired private PenaltyCalculationRepository penaltyCalculationRepository;

    @Override
    public BreachReport generateReport(Long contractId) {
        PenaltyCalculation calc = penaltyCalculationRepository
            .findTopByContractIdOrderByCalculatedAtDesc(contractId)
            .orElseThrow(() -> new ResourceNotFoundException("No calculation found"));

        // Use manual instantiation if Builder is still failing in your environment
        BreachReport report = new BreachReport();
        report.setContractId(contractId);
        report.setDaysDelayed(calc.getDaysDelayed());
        report.setPenaltyAmount(calc.getCalculatedPenalty());
        
        return breachReportRepository.save(report);
    }

    @Override
    public List<BreachReport> getReportsByContract(Long contractId) {
        return breachReportRepository.findAll(); 
    }
}