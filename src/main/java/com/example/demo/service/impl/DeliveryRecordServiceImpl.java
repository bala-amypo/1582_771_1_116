package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.entity.Contract;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.ContractRepository;
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
    public List<DeliveryRecord> getDeliveriesByContractId(Long contractId) {
        return contractRepository.findById(contractId)
                .map(deliveryRecordRepository::findByContract)
                .orElse(List.of());
    }

    @Override
    public DeliveryRecord getLatestDelivery(Long contractId) {
        return contractRepository.findById(contractId)
                .map(deliveryRecordRepository::findTopByContractOrderByDeliveryDateDesc)
                .orElse(null);
    }
}
