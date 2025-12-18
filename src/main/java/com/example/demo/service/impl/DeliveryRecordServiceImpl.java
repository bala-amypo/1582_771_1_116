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

    private final DeliveryRecordRepository recordRepo;
    private final ContractRepository contractRepo;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository recordRepo,
                                     ContractRepository contractRepo) {
        this.recordRepo = recordRepo;
        this.contractRepo = contractRepo;
    }

    public DeliveryRecord saveRecord(DeliveryRecord record) {
        return recordRepo.save(record);
    }

    public DeliveryRecord getRecordById(Long id) {
        return recordRepo.findById(id).orElse(null);
    }

    public List<DeliveryRecord> getRecordsForContract(Long contractId) {
        Contract contract = contractRepo.findById(contractId).orElse(null);
        return recordRepo.findByContract(contract);
    }
}
