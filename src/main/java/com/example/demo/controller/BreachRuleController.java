package com.example.demo.controller;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breach-rules")
@CrossOrigin(origins = "*")
public class BreachRuleController {

    private final BreachRuleService service;

    public BreachRuleController(BreachRuleService service) {
        this.service = service;
    }

    // POST – create rule
    @PostMapping
    public BreachRule createRule(@RequestBody BreachRule rule) {
        return service.createRule(rule);
    }

    // GET by id
    @GetMapping("/{id}")
    public BreachRule getRule(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    // GET all
    @GetMapping
    public List<BreachRule> getAllRules() {
        return service.getAllRules();
    }
}
