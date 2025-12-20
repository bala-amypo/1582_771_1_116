package com.example.demo.repository;

import com.example.demo.entity.BreachRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreachRuleRepository extends JpaRepository<BreachRule, Long> {

    List<BreachRule> findByActiveTrue();
}
