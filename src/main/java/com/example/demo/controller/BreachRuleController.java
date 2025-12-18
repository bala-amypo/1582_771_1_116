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
    public BreachRule create(@RequestBody BreachRule rule) {
        return service.create(rule);
    }

    @GetMapping
    public List<BreachRule> getAll() {
        return service.getAll();
    }
}
