package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping
    public Contract createContract(@RequestBody ContractDto dto) {
        Contract c = Contract.builder()
                .contractNumber(dto.getContractNumber())
                .title(dto.getTitle())
                .counterpartyName(dto.getCounterpartyName())
                .agreedDeliveryDate(dto.getAgreedDeliveryDate())
                .baseContractValue(dto.getBaseContractValue())
                .status("ACTIVE")
                .build();
        return contractService.createContract(c);
    }

    @GetMapping("/{id}")
    public Contract getContract(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable Long id, @RequestBody ContractDto dto) {
        Contract c = Contract.builder()
                .title(dto.getTitle())
                .counterpartyName(dto.getCounterpartyName())
                .agreedDeliveryDate(dto.getAgreedDeliveryDate())
                .baseContractValue(dto.getBaseContractValue())
                .build();
        return contractService.updateContract(id, c);
    }

    @PatchMapping("/{id}/status")
    public Contract updateStatus(@PathVariable Long id) {
        contractService.updateContractStatus(id);
        return contractService.getContractById(id);
    }
}
