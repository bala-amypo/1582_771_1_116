package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final DeliveryRecordRepository deliveryRecordRepository;

    public ContractServiceImpl(ContractRepository contractRepository,
                               DeliveryRecordRepository deliveryRecordRepository) {
        this.contractRepository = contractRepository;
        this.deliveryRecordRepository = deliveryRecordRepository;
    }

    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public Contract updateContract(Long id, Contract contract) {
        Contract existing = contractRepository.findById(id).orElseThrow();
        existing.setTitle(contract.getTitle());
        existing.setCounterpartyName(contract.getCounterpartyName());
        existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
        existing.setBaseContractValue(contract.getBaseContractValue());
        return contractRepository.save(existing);
    }

    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElseThrow();
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public void updateContractStatus(Long id) {
        Contract contract = contractRepository.findById(id).orElseThrow();
        contract.setStatus("COMPLETED");
        contractRepository.save(contract);
    }
}
