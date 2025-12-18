package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryRecord;
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
    public DeliveryRecord saveDeliveryRecord(DeliveryRecord record) {
        return deliveryRecordRepository.save(record);
    }

    @Override
    public DeliveryRecord getDeliveryRecordById(Long id) {
        return deliveryRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryRecord> getAllDeliveryRecords() {
        return deliveryRecordRepository.findAll();
    }

    @Override
    public void deleteDeliveryRecord(Long id) {
        deliveryRecordRepository.deleteById(id);
    }
}
