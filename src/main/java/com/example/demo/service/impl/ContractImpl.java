package com.example.demo.impl

import com.example.demo.entity.Contract;

import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractImpl implements ContractService {

    private final ContractRepository contractRepository;

    // Constructor Injection
    public ContractImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract existing = getContractById(id);
        existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
        existing.setBaseContractValue(contract.getBaseContractValue());
        existing.setStatus(contract.getStatus());

        return contractRepository.save(existing);
    }

   

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public void updateContractStatus(Long contractid) {
        Contract contract = getContractById(contractid);

        // Status updated manually (no delivery logic here)
        contract.setStatus("UPDATED");

        contractRepository.save(contract);
    }
}

