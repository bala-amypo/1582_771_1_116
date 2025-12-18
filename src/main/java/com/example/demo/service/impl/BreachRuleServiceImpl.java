package com.example.portal.service.impl;

import java.util.List;


import com.example.portal.Repository.ContractRepository;
import com.example.portal.Repository.DeliveryRecordRepository;
import com.example.portal.entity.Contract;
import com.example.portal.service.ContractService;

public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final DeliveryRecordRepository deliveryRecordRepository;

    public ContractServiceImpl(ContractRepository contractRepository,
                               DeliveryRecordRepository deliveryRecordRepository) {
        this.contractRepository = contractRepository;
        this.deliveryRecordRepository = deliveryRecordRepository;
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract existing = contractRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(contract.getTitle());
        existing.setCounterpartyName(contract.getCounterpartyName());
        existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
        existing.setBaseContractValue(contract.getBaseContractValue());

        return contractRepository.save(existing);
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public void updateContractStatus(Long contractid) {
        Contract contract = getContractById(contractid);
        if (contract == null) return;

       deliveryRecordRepository
    .findFirstByContractIdOrderByDeliveryDateDesc(contractid)
    .ifPresent(record -> {
        if (record.getDeliveryDate().after(contract.getAgreedDeliveryDate())) {
            contract.setStatus("BREACHED");
        } else {
            contract.setStatus("COMPLETED");
        }
        contractRepository.save(contract);
    });

    }
} 