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

    // POST /api/breach-rules
    @PostMapping
    public BreachRule createRule(@RequestBody BreachRule rule) {
        return service.createRule(rule);
    }

    // PUT /api/breach-rules/{id}
    @PutMapping("/{id}")
    public BreachRule updateRule(
            @PathVariable Long id,
            @RequestBody BreachRule rule) {
        return service.updateRule(id, rule);
    }

    // GET /api/breach-rules/{id}
    @GetMapping("/{id}")
    public BreachRule getRule(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    // GET /api/breach-rules
    @GetMapping
    public List<BreachRule> getAllRules() {
        return service.getAllRules();
    }

    // PUT /api/breach-rules/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public BreachRule deactivateRule(@PathVariable Long id) {
        return service.deactivateRule(id);
    }
}
