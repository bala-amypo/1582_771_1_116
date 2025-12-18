package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository repository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record) {
        return repository.save(record);
    }

    @Override
    public DeliveryRecord getRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        return repository.findByContractId(contractId);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        return repository.findTopByContractIdOrderByActualDeliveryDateDesc(contractId);
    }
}
