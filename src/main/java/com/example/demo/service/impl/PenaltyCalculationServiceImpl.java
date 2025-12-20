package com.example.demo.service.impl;

import com.example.demo.service.PenaltyCalculationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    @Override
    public List<?> getCalculationsForContract(Long contractId) {
        // TODO: implement logic
        return List.of(); // temporary empty list
    }
}
