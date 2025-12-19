package com.example.demo.service;

import com.example.demo.entity.PenaltyCalculation;
import java.util.List;

public interface PenaltyCalculationService {

    PenaltyCalculation save(PenaltyCalculation calculation);

    List<PenaltyCalculation> getAll();
}
