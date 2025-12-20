package com.example.demo.service.impl;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.service.PenaltyCalculationService;
import org.springframework.stereotype.Service;

@Service
public class PenaltyCalculationServiceImpl implements PenaltyCalculationService {

    private final BreachRuleRepository ruleRepository;

    public PenaltyCalculationServiceImpl(BreachRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public double calculatePenalty(int days) {

        BreachRule rule = ruleRepository
                .findFirstByActiveTrueOrderByIsDefaultRuleDesc()
                .orElse(null);

        if (rule == null) {
            return 0;
        }

        return days * rule.getPenaltyPerDay();
    }
}
