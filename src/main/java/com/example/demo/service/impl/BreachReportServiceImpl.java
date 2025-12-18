package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.BreachReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    private final BreachReportRepository reportRepo;
    private final ContractRepository contractRepo;
    private final PenaltyCalculationRepository penaltyRepo;

    public BreachReportServiceImpl(
            BreachReportRepository reportRepo,
            ContractRepository contractRepo,
            PenaltyCalculationRepository penaltyRepo) {
        this.reportRepo = reportRepo;
        this.contractRepo = contractRepo;
        this.penaltyRepo = penaltyRepo;
    }

    public BreachReport generateReport(Long contractId) {

        Contract contract = contractRepo.findById(contractId).orElse(null);
        PenaltyCalculation pc =
                penaltyRepo.findByContract(contract).stream().findFirst().orElse(null);

        BreachReport report = new BreachReport();
        report.setContract(contract);

        if (pc != null) {
            report.setDaysDelayed(pc.getDaysDelayed());
            report.setRuleName(pc.getAppliedRule().getName());
            report.setSummary("Penalty calculated successfully");
        } else {
            report.setSummary("No penalty applied");
        }

        return reportRepo.save(report);
    }

    public BreachReport getReportById(Long id) {
        return reportRepo.findById(id).orElse(null);
    }

    public List<BreachReport> getReportsForContract(Long contractId) {
        return reportRepo.findByContract(
                contractRepo.findById(contractId).orElse(null));
    }

    public List<BreachReport> getAllReports() {
        return reportRepo.findAll();
    }
}
