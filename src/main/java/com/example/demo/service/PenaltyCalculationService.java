package com.example.portal.service;

import java.util.List;

import com.example.portal.entity.PenaltyCalculation;

public interface PenaltyCalculationService {

    PenaltyCalculation calculatePenalty(Long contractId);

    PenaltyCalculation getCalculationById(Long id);

    List<PenaltyCalculation> getCalculationsForContract(Long contractId);
}

