package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    private final PenaltyCalculationRepository penaltyRepository;
    private final ContractRepository contractRepository;
    private final DeliveryRecordRepository deliveryRepository;
    private final BreachRuleRepository ruleRepository;

    public PenaltyCalculationServiceImpl(PenaltyCalculationRepository penaltyRepository,
                                         ContractRepository contractRepository,
                                         DeliveryRecordRepository deliveryRepository,
                                         BreachRuleRepository ruleRepository) {
        this.penaltyRepository = penaltyRepository;
        this.contractRepository = contractRepository;
        this.deliveryRepository = deliveryRepository;
        this.ruleRepository = ruleRepository;
    }

    public PenaltyCalculation calculatePenalty(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElseThrow();
        DeliveryRecord delivery = deliveryRepository
                .findFirstByContractIdOrderByDeliveryDateDesc(contractId).orElse(null);
        BreachRule rule = ruleRepository.findFirstByActiveTrueOrderByIsDefaultRuleDesc().orElseThrow();

        long delay = delivery == null ? 0 :
                ChronoUnit.DAYS.between(contract.getAgreedDeliveryDate(), delivery.getDeliveryDate());

        if (delay < 0) delay = 0;

        BigDecimal penalty = rule.getPenaltyPerDay().multiply(BigDecimal.valueOf(delay));

        PenaltyCalculation calc = new PenaltyCalculation();
        calc.setContract(contract);
        calc.setDaysDelayed((int) delay);
        calc.setCalculatedPenalty(penalty);

        return penaltyRepository.save(calc);
    }

    public PenaltyCalculation getCalculationById(Long id) {
        return penaltyRepository.findById(id).orElseThrow();
    }

    public List<PenaltyCalculation> getCalculationsForContract(Long contractId) {
        return penaltyRepository.findByContractId(contractId);
    }
}
