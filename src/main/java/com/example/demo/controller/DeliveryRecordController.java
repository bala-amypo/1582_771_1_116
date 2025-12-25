package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryRecordController {

    @Autowired
    private DeliveryRecordService deliveryRecordService;

    @PostMapping
    public ResponseEntity<DeliveryRecord> recordDelivery(@RequestBody DeliveryRecord record) {
        return ResponseEntity.ok(deliveryRecordService.createDeliveryRecord(record));
    }

    @GetMapping("/latest/{contractId}")
    public ResponseEntity<DeliveryRecord> getLatest(@PathVariable Long contractId) {
        return ResponseEntity.ok(deliveryRecordService.getLatestDeliveryRecord(contractId));
    }
}