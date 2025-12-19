package com.example.demo.controller;

import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin(origins = "*")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    // POST /api/contracts
    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }

    // PUT /api/contracts/{id}
    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        return contractService.updateContract(id, contract);
    }

    // GET /api/contracts/{id}
    @GetMapping("/{id}")
    public Contract getContract(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    // GET /api/contracts
    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    // PUT /api/contracts/{id}/update-status
    @PutMapping("/{id}/update-status")
    public Contract updateStatus(@PathVariable Long id) {
        return contractService.updateContractStatus(id);
    }
}
