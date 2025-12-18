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

    private final DeliveryRecordRepository deliveryRecordRepository;
    private final ContractRepository contractRepository;

    public DeliveryRecordServiceImpl(
            DeliveryRecordRepository deliveryRecordRepository,
            ContractRepository contractRepository) {
        this.deliveryRecordRepository = deliveryRecordRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord deliveryRecord) {
        return deliveryRecordRepository.save(deliveryRecord);
    }

    @Override
    public DeliveryRecord getRecordById(Long id) {
        return deliveryRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElse(null);
        if (contract == null) return List.of();
        return deliveryRecordRepository.findByContract(contract);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElse(null);
        if (contract == null) return null;
        return deliveryRecordRepository
                .findTopByContractOrderByDeliveryDateDesc(contract);
    }
}
