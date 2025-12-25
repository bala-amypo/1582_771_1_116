package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.ContractService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;
    private DeliveryRecordRepository deliveryRecordRepository;

    public ContractServiceImpl() {}

    @Override
    public Contract createContract(Contract contract) {
        if (contract.getBaseContractValue() == null || contract.getBaseContractValue().intValue() <= 0)
            throw new IllegalArgumentException("Base contract value must be positive");
        contract.setStatus(contract.getStatus() != null ? contract.getStatus() : "ACTIVE");
        return contractRepository.save(contract);
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found"));
    }

    @Override
    public Contract updateContract(Long id, Contract updated) {
        Contract existing = getContractById(id);
        if (updated.getTitle() != null) existing.setTitle(updated.getTitle());
        if (updated.getCounterpartyName() != null) existing.setCounterpartyName(updated.getCounterpartyName());
        if (updated.getAgreedDeliveryDate() != null) existing.setAgreedDeliveryDate(updated.getAgreedDeliveryDate());
        if (updated.getBaseContractValue() != null) existing.setBaseContractValue(updated.getBaseContractValue());
        return contractRepository.save(existing);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public void updateContractStatus(Long contractId) {
        Contract c = getContractById(contractId);
        var deliveryOpt = deliveryRecordRepository.findFirstByContractIdOrderByDeliveryDateDesc(contractId);
        if (deliveryOpt.isEmpty()) {
            c.setStatus("ACTIVE");
        } else if (deliveryOpt.get().getDeliveryDate().isAfter(c.getAgreedDeliveryDate())) {
            c.setStatus("BREACHED");
        } else {
            c.setStatus("ACTIVE");
        }
        contractRepository.save(c);
    }
}
