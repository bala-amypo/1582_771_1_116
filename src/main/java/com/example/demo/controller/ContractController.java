package com.example.demo.controller;

import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin
public class ContractController {

    private final ContractService service;

    public ContractController(ContractService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Contract> create(@RequestBody Contract contract) {
        return ResponseEntity.ok(service.createContract(contract));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> update(@PathVariable Long id, @RequestBody Contract contract) {
        return ResponseEntity.ok(service.updateContract(id, contract));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getContractById(id));
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getAll() {
        return ResponseEntity.ok(service.getAllContracts());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id) {
        service.updateContractStatus(id);
        return ResponseEntity.ok().build();
    }
}
