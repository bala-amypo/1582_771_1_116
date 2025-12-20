package com.example.demo.repository;

import com.example.demo.entity.PenaltyCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PenaltyCalculationRepository extends JpaRepository<PenaltyCalculation, Long> {

    PenaltyCalculation findTopByContractIdOrderByIdDesc(Long contractId);

    List<PenaltyCalculation> findByContractId(Long contractId);
}
