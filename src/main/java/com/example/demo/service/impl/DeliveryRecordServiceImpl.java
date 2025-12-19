package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository repository;
    private final ContractRepository contractRepository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repository,
                                     ContractRepository contractRepository) {
        this.repository = repository;
        this.contractRepository = contractRepository;
    }

    public DeliveryRecord createDeliveryRecord(DeliveryRecord record) {
        return repository.save(record);
    }

    public DeliveryRecord getRecordById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        return repository.findByContractId(contractId);
    }

    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        return repository.findFirstByContractIdOrderByDeliveryDateDesc(contractId).orElse(null);
    }
}
