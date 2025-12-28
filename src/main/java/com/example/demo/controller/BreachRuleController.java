package com.example.demo.controller;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breach-rules") // 🔴 FIXED PATH (NO CONFLICT)
public class BreachRuleController {

    private final BreachRuleRepository breachRuleRepository;

    public BreachRuleController(BreachRuleRepository breachRuleRepository) {
        this.breachRuleRepository = breachRuleRepository;
    }

    // GET /api/breach-rules
    @GetMapping
    public List<BreachRule> list() {
        return breachRuleRepository.findAll();
    }

    // GET /api/breach-rules/{id}
    @GetMapping("/{id}")
    public BreachRule getById(@PathVariable Long id) {
        return breachRuleRepository.findById(id).orElse(null);
    }
}
