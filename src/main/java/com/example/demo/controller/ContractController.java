package com.example.demo.controller;

import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin("*")
public class ContractController {

    private final ContractService service;

    public ContractController(ContractService service) {
        this.service = service;
    }

    @PostMapping
    public Contract create(@RequestBody Contract contract) {
        return service.createContract(contract);
    }

    @GetMapping("/{id}")
    public Contract get(@PathVariable Long id) {
        return service.getContract(id);
    }

    @GetMapping
    public List<Contract> getAll() {
        return service.getAllContracts();
    }
}
