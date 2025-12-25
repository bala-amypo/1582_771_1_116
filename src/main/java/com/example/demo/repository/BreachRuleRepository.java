package com.example.demo.repository;

import com.example.demo.entity.BreachRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BreachRuleRepository extends JpaRepository<BreachRule, Long> {
    List<BreachRule> findAllByActiveTrue();
    
    // Logic: find active rules, prioritizing those marked as default
    Optional<BreachRule> findFirstByActiveTrueOrderByIsDefaultRuleDesc();
}