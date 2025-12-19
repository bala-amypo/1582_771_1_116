package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract createContract(Contract contract) {
        contract.setCreatedAt(Instant.now());
        contract.setUpdatedAt(Instant.now());
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract existing = getContractById(id);
        existing.setTitle(contract.getTitle());
        existing.setCounterpartyName(contract.getCounterpartyName());
        existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
        existing.setBaseContractValue(contract.getBaseContractValue());
        existing.setStatus(contract.getStatus());
        existing.setUpdatedAt(Instant.now());
        return contractRepository.save(existing);
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract updateContractStatus(Long id) {
        Contract contract = getContractById(id);
        contract.setStatus("BREACHED");
        contract.setUpdatedAt(Instant.now());
        return contractRepository.save(contract);
    }
}
