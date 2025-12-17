package com.example.demo.impl;

import com.example.demo.entity.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContractById(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        return contract.orElse(null); // ✅ No exception
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {

        Contract existing = getContractById(id);

        if (existing != null) {
            existing.setTitle(contract.getTitle());
            existing.setCounterpartyName(contract.getCounterpartyName());
            existing.setContractNumber(contract.getContractNumber());
            return contractRepository.save(existing);
        }

        return null; // ✅ No exception
    }

    @Override
    public void deleteContract(Long id) {
        Contract contract = getContractById(id);
        if (contract != null) {
            contractRepository.delete(contract);
        }
    }
}
