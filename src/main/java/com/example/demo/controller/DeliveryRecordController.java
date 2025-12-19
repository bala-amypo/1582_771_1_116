package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-records")
@CrossOrigin(origins = "*")
public class DeliveryRecordController {

    private final DeliveryRecordService deliveryService;

    public DeliveryRecordController(DeliveryRecordService deliveryService) {
        this.deliveryService = deliveryService;
    }

    // POST /api/delivery-records
    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord record) {
        return deliveryService.createDeliveryRecord(record);
    }

    // GET /api/delivery-records/{id}
    @GetMapping("/{id}")
    public DeliveryRecord getById(@PathVariable Long id) {
        return deliveryService.getRecordById(id);
    }

    // GET /api/delivery-records/contract/{contractId}
    @GetMapping("/contract/{contractId}")
    public List<DeliveryRecord> getByContract(@PathVariable Long contractId) {
        return deliveryService.getDeliveryRecordsForContract(contractId);
    }

    // GET /api/delivery-records/contract/{contractId}/latest
    @GetMapping("/contract/{contractId}/latest")
    public DeliveryRecord getLatest(@PathVariable Long contractId) {
        return deliveryService.getLatestDeliveryRecord(contractId);
    }
}
