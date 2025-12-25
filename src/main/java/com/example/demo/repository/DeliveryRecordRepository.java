package com.example.demo.repository;

import com.example.demo.entity.DeliveryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord, Long> {
    // Finds the latest delivery record to check against the agreed date
    Optional<DeliveryRecord> findFirstByContractIdOrderByDeliveryDateDesc(Long contractId);
}