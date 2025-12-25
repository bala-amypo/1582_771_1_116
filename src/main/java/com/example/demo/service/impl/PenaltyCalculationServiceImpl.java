package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    @Autowired private ContractRepository contractRepository;
    @Autowired private DeliveryRecordRepository deliveryRecordRepository;
    @Autowired private BreachRuleRepository breachRuleRepository;
    @Autowired private PenaltyCalculationRepository penaltyCalculationRepository;

    @Override
    public PenaltyCalculation calculatePenalty(Long contractId) {
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        DeliveryRecord record = deliveryRecordRepository.findFirstByContractIdOrderByDeliveryDateDesc(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("No delivery record found"));

        BreachRule rule = breachRuleRepository.findFirstByActiveTrueOrderByIsDefaultRuleDesc()
                .orElseThrow(() -> new ResourceNotFoundException("No active breach rule found"));

        long daysDelayed = ChronoUnit.DAYS.between(contract.getAgreedDeliveryDate(), record.getDeliveryDate());
        if (daysDelayed < 0) daysDelayed = 0;

        // Formula: min( (days * penaltyPerDay), (baseValue * maxPercentage/100) )
        BigDecimal rawPenalty = rule.getPenaltyPerDay().multiply(BigDecimal.valueOf(daysDelayed));
        BigDecimal maxCap = contract.getBaseContractValue()
                .multiply(BigDecimal.valueOf(rule.getMaxPenaltyPercentage() / 100.0));
        
        BigDecimal finalPenalty = rawPenalty.min(maxCap);

        PenaltyCalculation calc = PenaltyCalculation.builder()
                .contract(contract)
                .daysDelayed((int) daysDelayed)
                .calculatedPenalty(finalPenalty)
                .build();

        return penaltyCalculationRepository.save(calc);
    }

    @Override
    public PenaltyCalculation getCalculationById(Long id) {
        return penaltyCalculationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }

    @Override
    public List<PenaltyCalculation> getCalculationsForContract(Long contractId) {
        return penaltyCalculationRepository.findByContractId(contractId);
    }
}