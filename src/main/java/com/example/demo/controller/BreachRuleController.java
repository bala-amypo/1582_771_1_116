package com.example.demo.controller;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/breach-rules")
public class BreachRuleController {

    @Autowired
    private BreachRuleService breachRuleService;

    @PostMapping
    public BreachRule createRule(@RequestBody BreachRule rule) {
        return breachRuleService.createRule(rule);
    }

    @GetMapping("/{id}")
    public BreachRule getRule(@PathVariable Long id) {
        return breachRuleService.getRuleById(id);
    }

    @GetMapping
    public List<BreachRule> getAllRules() {
        return breachRuleService.getAllRules();
    }

    @PatchMapping("/{id}/deactivate")
    public BreachRule deactivateRule(@PathVariable Long id) {
        breachRuleService.deactivateRule(id);
        return breachRuleService.getRuleById(id);
    }
}
