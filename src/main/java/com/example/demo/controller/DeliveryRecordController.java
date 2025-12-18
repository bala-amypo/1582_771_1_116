package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery-records")
public class DeliveryRecordController {

    private final DeliveryRecordService deliveryRecordService;

    public DeliveryRecordController(DeliveryRecordService deliveryRecordService) {
        this.deliveryRecordService = deliveryRecordService;
    }

    @PostMapping
    public DeliveryRecord addRecord(@RequestBody DeliveryRecord record) {
        return deliveryRecordService.saveRecord(record);
    }

    @GetMapping("/{id}")
    public DeliveryRecord getRecord(@PathVariable Long id) {
        return deliveryRecordService.getRecordById(id);
    }

    @GetMapping("/contract/{contractId}")
    public List<DeliveryRecord> getRecordsForContract(@PathVariable Long contractId) {
        return deliveryRecordService.getRecordsForContract(contractId);
    }
}
