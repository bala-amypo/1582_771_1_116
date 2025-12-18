package com.example.demo.repository;

import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord, Long> {

    // get all deliveries for a contract
    List<DeliveryRecord> findByContract(Contract contract);

    // get latest delivery by deliveryDate
    DeliveryRecord findTopByContractOrderByDeliveryDateDesc(Contract contract);
}
