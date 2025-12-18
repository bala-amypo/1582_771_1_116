package com.example.portal.service;

import java.util.List;

import com.example.portal.entity.BreachRule;

public interface BreachRuleService {

    BreachRule createRule(BreachRule rule);

    BreachRule updateRule(Long id, BreachRule rule);

    List<BreachRule> getAllRules();

    BreachRule getRuleById(Long id);

    void deactivateRule(Long id);

    BreachRule getActiveDefaultOrFirst();
}
