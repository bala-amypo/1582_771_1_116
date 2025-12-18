package com.example.demo.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
