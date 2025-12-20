package com.example.demo.service.impl;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.service.BreachRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachRuleServiceImpl implements BreachRuleService {

    private final BreachRuleRepository repository;

    public BreachRuleServiceImpl(BreachRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public BreachRule createRule(BreachRule rule) {
        rule.setActive(true);
        return repository.save(rule);
    }

    @Override
    public BreachRule updateRule(Long id, BreachRule rule) {
        BreachRule existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setRuleName(rule.getRuleName());
        existing.setDescription(rule.getDescription());
        existing.setActive(rule.isActive());
        existing.setPenaltyPerDay(rule.getPenaltyPerDay());
        existing.setDefaultRule(rule.isDefaultRule());

        return repository.save(existing);
    }

    @Override
    public BreachRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<BreachRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public BreachRule deactivateRule(Long id) {
        BreachRule rule = repository.findById(id).orElse(null);
        if (rule == null) {
            return null;
        }
        rule.setActive(false);
        return repository.save(rule);
    }
}
