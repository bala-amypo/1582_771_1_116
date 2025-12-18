package com.example.demo.controller;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/delivery-records")
public class DeliveryRecordController {

    private final DeliveryRecordService service;

    public DeliveryRecordController(DeliveryRecordService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord record) {
        return service.create(record);
    }

    @GetMapping("/contract/{id}")
    public List<DeliveryRecord> getByContract(@PathVariable Long id) {
        return service.getByContract(id);
    }
}
