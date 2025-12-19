package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository deliveryRecordRepository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository deliveryRecordRepository) {
        this.deliveryRecordRepository = deliveryRecordRepository;
    }

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record) {
        return deliveryRecordRepository.save(record);
    }

    @Override
    public DeliveryRecord getRecordById(Long id) {
        return deliveryRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery record not found"));
    }

    @Override
    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        return deliveryRecordRepository.findByContractIdOrderByDeliveryDateAsc(contractId);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        DeliveryRecord record =
                deliveryRecordRepository.findFirstByContractIdOrderByDeliveryDateDesc(contractId);

        if (record == null) {
            throw new ResourceNotFoundException("No delivery record found");
        }
        return record;
    }
}
