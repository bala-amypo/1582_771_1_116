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

    public BreachRule createRule(BreachRule rule) {
        return repository.save(rule);
    }

    public BreachRule updateRule(Long id, BreachRule rule) {
        BreachRule existing = repository.findById(id).orElseThrow();
        existing.setRuleName(rule.getRuleName());
        existing.setPenaltyPerDay(rule.getPenaltyPerDay());
        existing.setMaxPenaltyPercentage(rule.getMaxPenaltyPercentage());
        existing.setActive(rule.getActive());
        existing.setIsDefaultRule(rule.getIsDefaultRule());
        return repository.save(existing);
    }

    public BreachRule getActiveDefaultOrFirst() {
        return repository.findFirstByActiveTrueOrderByIsDefaultRuleDesc()
                .orElse(repository.findAll().get(0));
    }

    public List<BreachRule> getAllRules() {
        return repository.findAll();
    }

    public void deactivateRule(Long id) {
        BreachRule rule = repository.findById(id).orElseThrow();
        rule.setActive(false);
        repository.save(rule);
    }
}
