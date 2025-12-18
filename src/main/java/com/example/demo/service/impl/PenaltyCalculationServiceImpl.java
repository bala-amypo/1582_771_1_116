package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.PenaltyCalculationRepository;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    private final PenaltyCalculationRepository repository;
    private final ContractRepository contractRepository;

    public PenaltyCalculationServiceImpl(
            PenaltyCalculationRepository repository,
            ContractRepository contractRepository) {
        this.repository = repository;
        this.contractRepository = contractRepository;
    }

    public PenaltyCalculation getPenaltyById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<PenaltyCalculation> getPenaltiesForContract(Long contractId) {
        return repository.findByContract(
                contractRepository.findById(contractId).orElse(null));
    }

    public List<PenaltyCalculation> getAllPenalties() {
        return repository.findAll();
    }
}
