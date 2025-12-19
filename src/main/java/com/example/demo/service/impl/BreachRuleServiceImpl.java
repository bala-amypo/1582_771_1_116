package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.BreachReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    private final ContractRepository contractRepository;
    private final PenaltyCalculationRepository penaltyRepository;
    private final BreachReportRepository reportRepository;

    public BreachReportServiceImpl(
            ContractRepository contractRepository,
            PenaltyCalculationRepository penaltyRepository,
            BreachReportRepository reportRepository) {

        this.contractRepository = contractRepository;
        this.penaltyRepository = penaltyRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public BreachReport generateReport(Long contractId) {

        Optional<Contract> contractOpt = contractRepository.findById(contractId);
        if (contractOpt.isEmpty()) return null;

        PenaltyCalculation penalty =
                penaltyRepository.findTopByContractIdOrderByIdDesc(contractId);
        if (penalty == null) return null;

        BreachReport report = new BreachReport(
                contractOpt.get(),
                penalty.getDaysDelayed(),
                penalty.getCalculatedPenalty(),
                "Contract breached due to late delivery"
        );

        return reportRepository.save(report);
    }

    @Override
    public BreachReport getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public List<BreachReport> getReportsForContract(Long contractId) {
        return reportRepository.findByContractId(contractId);
    }

    @Override
    public List<BreachReport> getAllReports() {
        return reportRepository.findAll();
    }
}
