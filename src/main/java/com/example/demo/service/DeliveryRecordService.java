package com.example.demo.service;

import com.example.demo.entity.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {

    DeliveryRecord createDeliveryRecord(DeliveryRecord deliveryRecord);

    DeliveryRecord getRecordById(Long id);

    List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId);

    DeliveryRecord getLatestDeliveryRecord(Long contractId);
}
