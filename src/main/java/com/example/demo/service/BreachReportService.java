package com.example.portal.service;

import java.util.List;

import com.example.portal.entity.BreachReport;

public interface BreachReportService {
    BreachReport generateReport (Long contractId);
    BreachReport getReportById(Long id);
    List<BreachReport> getReportsForContract(Long contrctId);
    List<BreachReport> getAllReports();
}
