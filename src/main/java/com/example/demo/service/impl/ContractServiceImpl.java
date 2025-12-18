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

    @Override
    public Contract createContract(Contract contract) {
        return repository.save(contract);
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
    public Contract updateContract(Long id, Contract updatedContract) {
    Contract existing = repository.findById(id).orElse(null);
    if (existing != null) {
        existing.setBaseContractValue(updatedContract.getBaseContractValue());
        existing.setAgreedDeliveryDate(updatedContract.getAgreedDeliveryDate());
        existing.setStatus(updatedContract.getStatus());
        return repository.save(existing);
    }
    return null;
}

}
