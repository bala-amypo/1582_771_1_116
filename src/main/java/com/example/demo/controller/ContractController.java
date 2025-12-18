package com.example.demo.controller;

import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    private final ContractService service;

    public ContractController(ContractService service) {
        this.service = service;
    }

    @PostMapping
    public Contract create(@RequestBody Contract contract) {
        return service.create(contract);
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Contract> getAll() {
        return service.getAll();
    }
}
