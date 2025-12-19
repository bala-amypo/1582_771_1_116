package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.BreachReportService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    private final BreachReportRepository reportRepository;
    private final PenaltyCalculationRepository penaltyRepository;
    private final ContractRepository contractRepository;

    public BreachReportServiceImpl(BreachReportRepository reportRepository,
                                   PenaltyCalculationRepository penaltyRepository,
                                   ContractRepository contractRepository) {
        this.reportRepository = reportRepository;
        this.penaltyRepository = penaltyRepository;
        this.contractRepository = contractRepository;
    }

    public BreachReport generateReport(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElseThrow();
        PenaltyCalculation calc = penaltyRepository
                .findTopByContractIdOrderByCalculatedAtDesc(contractId).orElseThrow();

        BreachReport report = new BreachReport();
        report.setContract(contract);
        report.setDaysDelayed(calc.getDaysDelayed());
        report.setPenaltyAmount(calc.getCalculatedPenalty());

        return reportRepository.save(report);
    }

    public BreachReport getReportById(Long id) {
        return reportRepository.findById(id).orElseThrow();
    }

    public List<BreachReport> getReportsForContract(Long contractId) {
        return reportRepository.findByContractId(contractId);
    }

    public List<BreachReport> getAllReports() {
        return reportRepository.findAll();
    }
}
