package com.example.demo.service;

import com.example.demo.entity.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {

    List<DeliveryRecord> getDeliveriesByContractId(Long contractId);

    DeliveryRecord getLatestDelivery(Long contractId);
}
