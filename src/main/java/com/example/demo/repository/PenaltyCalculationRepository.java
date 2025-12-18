package com.example.portal.Repository;

import com.example.portal.entity.PenaltyCalculation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PenaltyCalculationRepository
        extends JpaRepository<PenaltyCalculation, Long> {

    List<PenaltyCalculation> findByContractId(Long contractId);
}
