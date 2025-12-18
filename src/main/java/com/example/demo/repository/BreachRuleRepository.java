package com.example.portal.Repository;

import com.example.portal.entity.BreachRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BreachRuleRepository extends JpaRepository<BreachRule, Long> {

    Optional<BreachRule> findFirstByActiveTrueOrderByIsDefaultRuleDesc();
}
