package com.example.demo.repository;

import com.example.demo.entity.DeliveryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord, Long> {

    DeliveryRecord findFirstByContractIdOrderByDeliveryDateDesc(Long contractId);

    List<DeliveryRecord> findByContractIdOrderByDeliveryDateAsc(Long contractId);
}
