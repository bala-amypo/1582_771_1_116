package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
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
    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractid) {
        return deliveryRecordRepository
                .findByContractIdOrderByDeliveryDateAsc(contractid);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractid) {
        return deliveryRecordRepository
                .findFirstByContractIdOrderByDeliveryDateDesc(contractid)
                .orElse(null);
    }

    @Override
    public DeliveryRecord getRecordById(Long id) {
        return deliveryRecordRepository.findById(id).orElse(null);
    } 
    
}
