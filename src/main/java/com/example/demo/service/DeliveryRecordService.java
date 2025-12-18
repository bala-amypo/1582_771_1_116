package com.example.demo.service;

import com.example.demo.entity.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {

    DeliveryRecord saveRecord(DeliveryRecord record);

    DeliveryRecord getRecordById(Long id);

    List<DeliveryRecord> getRecordsForContract(Long contractId);
}
