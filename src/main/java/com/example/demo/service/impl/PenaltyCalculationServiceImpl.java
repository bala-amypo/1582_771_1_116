package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    private final ContractRepository contractRepository;
    private final DeliveryRecordRepository deliveryRecordRepository;
    private final BreachRuleRepository breachRuleRepository;
    private final PenaltyCalculationRepository penaltyRepository;

    public PenaltyCalculationServiceImpl(
            ContractRepository contractRepository,
            DeliveryRecordRepository deliveryRecordRepository,
            BreachRuleRepository breachRuleRepository,
            PenaltyCalculationRepository penaltyRepository) {

        this.contractRepository = contractRepository;
        this.deliveryRecordRepository = deliveryRecordRepository;
        this.breachRuleRepository = breachRuleRepository;
        this.penaltyRepository = penaltyRepository;
    }

    @Override
    public PenaltyCalculation calculatePenalty(Long contractId) {
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        DeliveryRecord record =
                deliveryRecordRepository.findFirstByContractIdOrderByDeliveryDateDesc(contractId);

        if (record == null) {
            throw new ResourceNotFoundException("No delivery record found");
        }

        BreachRule rule =
                breachRuleRepository.findFirstByActiveTrueOrderByIsDefaultRuleDesc();

        if (rule == null) {
            throw new ResourceNotFoundException("No active breach rule");
        }

        long daysDelayed =
                Math.max(0,
                        (record.getDeliveryDate().getTime()
                                - contract.getAgreedDeliveryDate().getTime())
                                / (1000 * 60 * 60 * 24));

        BigDecimal penalty =
                rule.getPenaltyPerDay().multiply(BigDecimal.valueOf(daysDelayed));

        PenaltyCalculation calculation = new PenaltyCalculation(
                contract,
                (int) daysDelayed,
                penalty,
                rule
        );

        return penaltyRepository.save(calculation);
    }

    @Override
    public PenaltyCalculation getCalculationById(Long id) {
        return penaltyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Penalty calculation not found"));
    }

    @Override
    public List<PenaltyCalculation> getCalculationsForContract(Long contractId) {
        return penaltyRepository.findByContractId(contractId);
    }
}
