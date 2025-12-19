package com.example.demo.controller;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breach-rules")
@CrossOrigin(origins = "*")
public class BreachRuleController {

    private final BreachRuleService ruleService;

    public BreachRuleController(BreachRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // POST /api/breach-rules
    @PostMapping
    public BreachRule create(@RequestBody BreachRule rule) {
        return ruleService.createRule(rule);
    }

    // PUT /api/breach-rules/{id}
    @Put
