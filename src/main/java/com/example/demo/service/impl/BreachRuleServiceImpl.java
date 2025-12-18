package com.example.demo.service.impl;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.service.BreachRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import jakarta.transaction.Transactional;

@Transactional

@Service
public class BreachRuleServiceImpl implements BreachRuleService {

    private final BreachRuleRepository repository;

    public BreachRuleServiceImpl(BreachRuleRepository repository) {
        this.repository = repository;
    }

    public BreachRule create(BreachRule rule) {
        return repository.save(rule);
    }

    public List<BreachRule> getAll() {
        return repository.findAll();
    }
}
