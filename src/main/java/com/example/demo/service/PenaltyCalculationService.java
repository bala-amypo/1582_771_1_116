package com.example.demo.service;

import com.example.demo.entity.PenaltyCalculation;
import java.util.List;

public interface PenaltyCalculationService {
    PenaltyCalculation save(PenaltyCalculation pc);
    List<PenaltyCalculation> getByContract(Long contractId);
}
