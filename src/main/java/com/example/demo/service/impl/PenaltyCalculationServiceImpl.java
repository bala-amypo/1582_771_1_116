package com.example.demo.service.impl;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import org.springframework.stereotype.Service;

@Service
public class PenaltyCalculationServiceImpl {

    private final BreachRuleRepository ruleRepository;

    public PenaltyCalculationServiceImpl(BreachRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

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
