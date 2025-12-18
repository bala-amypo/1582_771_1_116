package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.repository.PenaltyCalculationRepository;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    private final PenaltyCalculationRepository repository;

    public PenaltyCalculationServiceImpl(PenaltyCalculationRepository repository) {
        this.repository = repository;
    }

    @Override
    public PenaltyCalculation save(PenaltyCalculation calculation) {
        return repository.save(calculation);
    }

    @Override
    public List<PenaltyCalculation> getByContract(Long contractId) {
        return repository.findByContractId(contractId);
    }
}
