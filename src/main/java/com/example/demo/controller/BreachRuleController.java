package com.example.demo.controller;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breach-rules")
public class BreachRuleController {

    private final BreachRuleService breachRuleService;

    public BreachRuleController(BreachRuleService breachRuleService) {
        this.breachRuleService = breachRuleService;
    }

    @PostMapping
    public BreachRule addRule(@RequestBody BreachRule rule) {
        return breachRuleService.saveRule(rule);
    }

    @GetMapping("/{id}")
    public BreachRule getRule(@PathVariable Long id) {
        return breachRuleService.getRuleById(id);
    }

    @GetMapping
    public List<BreachRule> getAllRules() {
        return breachRuleService.getAllRules();
    }
}
