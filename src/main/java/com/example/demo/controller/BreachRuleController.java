package com.example.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portal.entity.BreachRule;
import com.example.portal.service.BreachRuleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/api/breach-rules")
public class BreachRuleController {
    private final BreachRuleService breachRuleService;

    public BreachRuleController(BreachRuleService breachRuleService) {
        this.breachRuleService = breachRuleService;
    }

    @PostMapping
    public BreachRule create(@RequestBody BreachRule rule) {
        return breachRuleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public BreachRule update(@PathVariable Long id, @RequestBody BreachRule rule) {
        return breachRuleService.updateRule(id, rule);
    }

    @GetMapping("/{id}")
    public BreachRule getById(@PathVariable Long id) {
        return breachRuleService.getRuleById(id);
    }

    @GetMapping
    public List<BreachRule> getAll() {
        return breachRuleService.getAllRules();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        breachRuleService.deactivateRule(id);
    }
    
}
