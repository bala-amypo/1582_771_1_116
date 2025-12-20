package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    private final ContractRepository contractRepository;
    private final DeliveryRecordRepository deliveryRepository;
    private final BreachRuleRepository ruleRepository;
    private final PenaltyCalculationRepository penaltyRepository;

    public PenaltyCalculationServiceImpl(
            ContractRepository contractRepository,
            DeliveryRecordRepository deliveryRepository,
            BreachRuleRepository ruleRepository,
            PenaltyCalculationRepository penaltyRepository) {

        this.contractRepository = contractRepository;
        this.deliveryRepository = deliveryRepository;
        this.ruleRepository = ruleRepository;
        this.penaltyRepository = penaltyRepository;
    }

    @Override
    public PenaltyCalculation calculatePenalty(Long contractId) {

        Optional<Contract> contractOpt = contractRepository.findById(contractId);
        if (contractOpt.isEmpty()) return null;

        DeliveryRecord record =
                deliveryRepository.findFirstByContractIdOrderByDeliveryDateDesc(contractId);
        if (record == null) return null;

        BreachRule rule =
                ruleRepository.findFirstByActiveTrueOrderByActiveDesc();


        if (rule == null) return null;

        long days =
                Math.max(0,
                        (record.getDeliveryDate().getTime()
                                - contractOpt.get().getAgreedDeliveryDate().getTime())
                                / (1000 * 60 * 60 * 24));

        BigDecimal penalty =
                rule.getPenaltyPerDay().multiply(BigDecimal.valueOf(days));

        PenaltyCalculation calculation = new PenaltyCalculation(
                contractOpt.get(),
                (int) days,
                penalty,
                rule
        );

        return penaltyRepository.save(calculation);
    }

    @Override
    public PenaltyCalculation getCalculationById(Long id) {
        return penaltyRepository.findById(id).orElse(null);
    }

    @Override
    public List<PenaltyCalculation> getCalculationsForContract(Long contractId) {
        return penaltyRepository.findByContractId(contractId);
    }
}
