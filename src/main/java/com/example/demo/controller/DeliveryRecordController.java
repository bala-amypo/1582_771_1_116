package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery-records")
@CrossOrigin("*")
public class DeliveryRecordController {

    private final DeliveryRecordService service;

    public DeliveryRecordController(DeliveryRecordService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord record) {
        return service.create(record);
    }

    @GetMapping("/contract/{contractId}")
    public List<DeliveryRecord> getByContract(@PathVariable Long contractId) {
        return service.getByContract(contractId);
    }
}
