package com.example.demo.service;

import com.example.demo.entity.PenaltyCalculation;
import java.util.List;

public interface PenaltyCalculationService {
    PenaltyCalculation getPenaltyById(Long id);
    List<PenaltyCalculation> getPenaltiesForContract(Long contractId);
    List<PenaltyCalculation> getAllPenalties();
}
