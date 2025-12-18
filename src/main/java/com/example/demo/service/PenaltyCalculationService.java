package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PenaltyCalculation;

public interface PenaltyCalculationService {

    PenaltyCalculation calculatePenalty(Long contractId);

    PenaltyCalculation getCalculationById(Long id);

    List<PenaltyCalculation> getCalculationsForContract(Long contractId);
}

