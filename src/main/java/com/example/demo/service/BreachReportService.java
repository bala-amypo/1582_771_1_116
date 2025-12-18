package com.example.demo.service;

import com.example.demo.entity.BreachReport;
import com.example.demo.entity.BreachRule;
import com.example.demo.entity.Contract;

import java.math.BigDecimal;
import java.util.List;

public interface BreachReportService {

    BreachReport createReport(
            Contract contract,
            int daysDelayed,
            BigDecimal penalty,
            BreachRule appliedRule
    );

    BreachReport getReportById(Long id);

    List<BreachReport> getAllReports();
}
