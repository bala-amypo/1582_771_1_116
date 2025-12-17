package com.example.demo.service;

import com.example.demo.entity.Contract;
import java.util.List;

public interface ContractService {

    List<Contract> getAllContracts();

    Contract getContractById(Long id);

    Contract createContract(Contract contract);

    Contract updateContract(Long id, Contract contract);

    void deleteContract(Long id);
}
