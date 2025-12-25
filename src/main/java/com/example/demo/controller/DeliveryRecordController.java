package com.example.demo.controller;

import com.example.demo.dto.DeliveryRecordDto;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery-records")
public class DeliveryRecordController {

    @Autowired
    private DeliveryRecordService deliveryRecordService;

    @PostMapping
    public DeliveryRecord createDeliveryRecord(@RequestBody DeliveryRecordDto dto) {
        DeliveryRecord rec = DeliveryRecord.builder()
                .contract(dto.getContract())
                .deliveryDate(dto.getDeliveryDate())
                .notes(dto.getNotes())
                .build();
        return deliveryRecordService.createDeliveryRecord(rec);
    }

    @GetMapping("/{id}")
    public DeliveryRecord getRecordById(@PathVariable Long id) {
        return deliveryRecordService.getRecordById(id);
    }

    @GetMapping("/latest/{contractId}")
    public DeliveryRecord getLatestDelivery(@PathVariable Long contractId) {
        return deliveryRecordService.getLatestDeliveryRecord(contractId);
    }

    @GetMapping("/contract/{contractId}")
    public List<DeliveryRecord> getDeliveryRecordsForContract(@PathVariable Long contractId) {
        return deliveryRecordService.getDeliveryRecordsForContract(contractId);
    }
}
