package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/api/delivery-records")
public class DeliveryRecordController {
     private final DeliveryRecordService deliveryRecordService;

    public DeliveryRecordController(DeliveryRecordService deliveryRecordService) {
        this.deliveryRecordService = deliveryRecordService;
    }

    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord record) {
        return deliveryRecordService.createDeliveryRecord(record);
    }

    @GetMapping("/{id}")
    public DeliveryRecord getById(@PathVariable Long id) {
        return deliveryRecordService.getRecordById(id);
    }

    @GetMapping("/contract/{contractid}")
    public List<DeliveryRecord> getByContract(@PathVariable Long contractid) {
        return deliveryRecordService.getDeliveryRecordsForContract(contractid);
    }

    @GetMapping("/contract/{contractid}/latest")
    public DeliveryRecord getLatest(@PathVariable Long contractid) {
        return deliveryRecordService.getLatestDeliveryRecord(contractid);
    }
}
    

