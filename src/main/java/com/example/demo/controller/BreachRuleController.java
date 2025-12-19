package com.example.demo.controller;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/breach-rules")
public class BreachRuleController {

    private final BreachRuleService service;

    public BreachRuleController(BreachRuleService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRule createRule(@RequestBody BreachRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public BreachRule updateRule(
            @PathVariable Long id,
            @RequestBody BreachRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/{id}")
    public BreachRule getRuleById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping
    public List<BreachRule> getAllRules() {
        return service.getAllRules();
    }

    @DeleteMapping("/{id}")
    public void deactivateRule(@PathVariable Long id) {
        service.deactivateRule(id);
    }

    @GetMapping("/active")
    public BreachRule getActiveRule() {
        return service.getActiveRule();
    }
}
