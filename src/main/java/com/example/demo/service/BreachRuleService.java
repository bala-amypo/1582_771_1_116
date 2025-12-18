package com.example.demo.service;

import com.example.demo.entity.BreachRule;
import java.util.List;

public interface BreachRuleService {
    BreachRule create(BreachRule rule);
    List<BreachRule> getAll();
}
