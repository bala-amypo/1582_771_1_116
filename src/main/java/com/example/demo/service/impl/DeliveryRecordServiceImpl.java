package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository deliveryRepo;
    private final ContractRepository contractRepo;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository deliveryRepo,
                                     ContractRepository contractRepo) {
        this.deliveryRepo = deliveryRepo;
        this.contractRepo = contractRepo;
    }

    public DeliveryRecord saveRecord(DeliveryRecord record) {
        return deliveryRepo.save(record);
    }

    public List<DeliveryRecord> getRecordsForContract(Long contractId) {
        Contract contract = contractRepo.findById(contractId).orElse(null);
        return deliveryRepo.findByContract(contract);
    }
}
