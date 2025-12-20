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

    // POST /api/breach-rules  → Create rule
    @PostMapping
    public BreachRule createRule(@RequestBody BreachRule rule) {
        return service.createRule(rule);
    }

    // PUT /api/breach-rules/{id} → Update rule
    @PutMapping("/{id}")
    public BreachRule updateRule(
            @PathVariable Long id,
            @RequestBody BreachRule rule) {
        return service.updateRule(id, rule);
    }

    // GET /api/breach-rules/{id} → Get rule
    @GetMapping("/{id}")
    public BreachRule getRuleById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    // GET /api/breach-rules → List all
    @GetMapping
    public List<BreachRule> getAllRules() {
        return service.getAllRules();
    }

    // PUT /api/breach-rules/{id}/deactivate → Deactivate rule
    @PutMapping("/{id}/deactivate")
    public void deactivateRule(@PathVariable Long id) {
        service.deactivateRule(id);
    }
}
