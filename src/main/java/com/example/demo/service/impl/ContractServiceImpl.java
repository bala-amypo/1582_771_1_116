package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;
    
    @Autowired
    private DeliveryRecordRepository deliveryRecordRepository;

    @Override
    public Contract createContract(Contract contract) {
        if (contract.getBaseContractValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Base contract value must be positive");
        }
        contract.setStatus("ACTIVE");
        return contractRepository.save(contract);
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
    public Contract updateContract(Long id, Contract details) {
        Contract existing = getContractById(id);
        existing.setTitle(details.getTitle());
        existing.setCounterpartyName(details.getCounterpartyName());
        existing.setBaseContractValue(details.getBaseContractValue());
        return contractRepository.save(existing);
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void updateContractStatus(Long id) {
        Contract c = getContractById(id);
        deliveryRecordRepository.findFirstByContractIdOrderByDeliveryDateDesc(id)
            .ifPresent(record -> {
                if (record.getDeliveryDate().isAfter(c.getAgreedDeliveryDate())) {
                    c.setStatus("BREACHED");
                } else {
                    c.setStatus("COMPLETED");
                }
                contractRepository.save(c);
            });
    }
}