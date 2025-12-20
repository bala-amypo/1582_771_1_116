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
    public ResponseEntity<BreachRule> createRule(
        @RequestBody BreachRule rule) {

    // 🔥 SAFETY: force ID to null
    rule.setId(null);

    BreachRule saved = breachRuleService.createRule(rule);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(saved);
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
