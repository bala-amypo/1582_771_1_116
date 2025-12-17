package com.example.demo.controller;

import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }

    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable Long id,
                                   @RequestBody Contract contract) {
        return contractService.updateContract(id, contract);
    }

    @DeleteMapping("/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
        return "Deleted successfully";
    }
}
