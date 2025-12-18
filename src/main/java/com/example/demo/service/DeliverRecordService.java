package com.example.demo.service;

import com.example.demo.entity.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {

    DeliveryRecord saveDeliveryRecord(DeliveryRecord record);

    DeliveryRecord getDeliveryRecordById(Long id);

    List<DeliveryRecord> getAllDeliveryRecords();

    void deleteDeliveryRecord(Long id);
}
