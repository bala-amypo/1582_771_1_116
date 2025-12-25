package com.example.demo.service;

import com.example.demo.entity.DeliveryRecord;

public interface DeliveryRecordService {
    DeliveryRecord createDeliveryRecord(DeliveryRecord record);
    DeliveryRecord getLatestDeliveryRecord(Long contractId);
    DeliveryRecord getRecordById(Long id);
}