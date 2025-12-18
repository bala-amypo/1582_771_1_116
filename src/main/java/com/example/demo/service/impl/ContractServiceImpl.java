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

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }
    @Override
    public void updateContractStatus(Long contractId) {
    contractRepository.findById(contractId).ifPresent(contract -> {
        contract.setStatus("UPDATED"); 
        contractRepository.save(contract);
    });
}

}
