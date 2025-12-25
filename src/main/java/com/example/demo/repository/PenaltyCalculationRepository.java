package com.example.demo.repository;

import com.example.demo.entity.PenaltyCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PenaltyCalculationRepository extends JpaRepository<PenaltyCalculation, Long> {
    List<PenaltyCalculation> findByContractId(Long contractId);
    
    // Gets the most recent calculation result for a contract
    Optional<PenaltyCalculation> findTopByContractIdOrderByCalculatedAtDesc(Long contractId);
}

// You can include BreachReportRepository in the same file or a separate one
@Repository
interface BreachReportRepository extends JpaRepository<com.example.demo.entity.BreachReport, Long> {
}