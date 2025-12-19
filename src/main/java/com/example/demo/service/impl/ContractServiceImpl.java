package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    public ContractServiceImpl(ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contract createContract(Contract contract) {
        contract.setCreatedAt(Instant.now());
        contract.setUpdatedAt(Instant.now());
        return repository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Optional<Contract> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Contract existing = optional.get();
        existing.setTitle(contract.getTitle());
        existing.setCounterpartyName(contract.getCounterpartyName());
        existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
        existing.setBaseContractValue(contract.getBaseContractValue());
        existing.setStatus(contract.getStatus());
        existing.setUpdatedAt(Instant.now());
        return repository.save(existing);
    }

    @Override
    public Contract getContractById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Contract> getAllContracts() {
        return repository.findAll();
    }

    @Override
    public Contract updateContractStatus(Long id) {
        Optional<Contract> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Contract contract = optional.get();
        contract.setStatus("BREACHED");
        contract.setUpdatedAt(Instant.now());
        return repository.save(contract);
    }
}
