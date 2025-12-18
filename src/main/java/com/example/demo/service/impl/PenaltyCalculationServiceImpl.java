package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PenaltyCalculationRepository;
import com.example.demo.rntity.BreachRule;
import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.service.PenaltyCalculationService;

public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    private final ContractRepository contractRepository;
    private final DeliveryRecordRepository deliveryRecordRepository;
    private final BreachRuleRepository breachRuleRepository;
    private final PenaltyCalculationRepository penaltyCalculationRepository;

    public PenaltyCalculationServiceImpl(
            ContractRepository contractRepository,
            DeliveryRecordRepository deliveryRecordRepository,
            BreachRuleRepository breachRuleRepository,
            PenaltyCalculationRepository penaltyCalculationRepository) {

        this.contractRepository = contractRepository;
        this.deliveryRecordRepository = deliveryRecordRepository;
        this.breachRuleRepository = breachRuleRepository;
        this.penaltyCalculationRepository = penaltyCalculationRepository;
    }

    @Override
    public PenaltyCalculation calculatePenalty(Long contractid) {

        Contract contract = contractRepository.findById(contractid).orElse(null);
        DeliveryRecord record = deliveryRecordRepository
                .findFirstByContractIdOrderByDeliveryDateDesc(contractid)
                .orElse(null);
        BreachRule rule = breachRuleRepository
                .findFirstByActiveTrueOrderByIsDefaultRuleDesc()
                .orElse(null);

        if (contract == null || record == null || rule == null) return null;

        long daysDelayed = ChronoUnit.DAYS.between(
                contract.getAgreedDeliveryDate().toInstant(),
                record.getDeliveryDate().toInstant());

        if (daysDelayed < 0) daysDelayed = 0;

        BigDecimal delayPenalty =
                rule.getPenaltyPerDay().multiply(BigDecimal.valueOf(daysDelayed));

        BigDecimal maxPenalty =
                contract.getBaseContractValue()
                        .multiply(BigDecimal.valueOf(rule.getMaxPenaltyPercentage() / 100));

        PenaltyCalculation calculation = new PenaltyCalculation();
        calculation.setContract(contract);
        calculation.setDaysDelayed((int) daysDelayed);
        calculation.setCalculatePenalty(delayPenalty.min(maxPenalty));
        calculation.setAppliedRule(rule);

        return penaltyCalculationRepository.save(calculation);
    }

    @Override
    public PenaltyCalculation getCalculationById(Long id) {
        return penaltyCalculationRepository.findById(id).orElse(null);
    }

    @Override
    public List<PenaltyCalculation> getCalculationsForContract(Long contractid) {
        return penaltyCalculationRepository.findByContractId(contractid);
    }
    
}
