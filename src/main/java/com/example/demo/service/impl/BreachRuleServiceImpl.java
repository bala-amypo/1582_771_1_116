package com.example.demo.service.impl;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.service.BreachRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreachRuleServiceImpl implements BreachRuleService {

    private final BreachRuleRepository repository;

    public BreachRuleServiceImpl(BreachRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public BreachRule createRule(BreachRule rule) {
        return repository.save(rule);
    }

    @Override
    public BreachRule updateRule(Long id, BreachRule rule) {
        Optional<BreachRule> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        BreachRule existing = optional.get();
        existing.setRuleName(rule.getRuleName());
        existing.setPenaltyPerDay(rule.getPenaltyPerDay());
        existing.setMaxPenaltyPercentage(rule.getMaxPenaltyPercentage());
        existing.setActive(rule.getActive());
      

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
    public void deactivateRule(Long id) {
        Optional<BreachRule> optional = repository.findById(id);
        if (optional.isPresent()) {
            BreachRule rule = optional.get();
            rule.setActive(false);
            repository.save(rule);
        }
    }

    @Override
    public BreachRule getActiveRule() {
        return repository.findFirstByActiveTrueOrderByActiveDesc();


    }
}
