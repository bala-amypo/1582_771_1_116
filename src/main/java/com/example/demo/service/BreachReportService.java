package com.example.demo.service;

import com.example.demo.entity.BreachReport;
import java.util.List;

public interface BreachReportService {

    BreachReport createBreachReport(BreachReport breachReport);

    BreachReport getBreachReportById(Long id);

    List<BreachReport> getAllBreachReports();
}
