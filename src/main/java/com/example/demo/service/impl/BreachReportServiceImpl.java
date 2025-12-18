package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;

public class BreachRuleServiceImpl implements BreachRuleService {

    private final BreachRuleRepository breachRuleRepository;

    public BreachRuleServiceImpl(BreachRuleRepository breachRuleRepository) {
        this.breachRuleRepository = breachRuleRepository;
    }

    @Override
    public BreachRule createRule(BreachRule rule) {
        return breachRuleRepository.save(rule);
    }

    @Override
    public BreachRule updateRule(Long id, BreachRule rule) {
        BreachRule existing = breachRuleRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setRuleName(rule.getRuleName());
        existing.setPenaltyPerDay(rule.getPenaltyPerDay());
        existing.setMaxPenaltyPercentage(rule.getMaxPenaltyPercentage());
        existing.setActive(rule.getActive());
        existing.setIsDefaultRule(rule.getIsDefaultRule());

        return breachRuleRepository.save(existing);
    }

    @Override
    public List<BreachRule> getAllRules() {
        return breachRuleRepository.findAll();
    }

    @Override
    public BreachRule getRuleById(Long id) {
        return breachRuleRepository.findById(id).orElse(null);
    }

    @Override
public void deactivateRule(Long id) {
    BreachRule rule = getRuleById(id);
    if (rule != null) {
        rule.setActive(false);
        breachRuleRepository.save(rule);
    }
}

@Override
public BreachRule getActiveDefaultOrFirst() {
    return breachRuleRepository
            .findFirstByActiveTrueOrderByIsDefaultRuleDesc()
            .orElse(null);
}

}
