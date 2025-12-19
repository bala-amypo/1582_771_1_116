package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    public ContractServiceImpl(ContractRepository repository) {
        this.repository = repository;
    }

    public Contract createContract(Contract contract) {
        return repository.save(contract);
    }

    public Contract getContract(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Contract> getAllContracts() {
        return repository.findAll();
    }
}
