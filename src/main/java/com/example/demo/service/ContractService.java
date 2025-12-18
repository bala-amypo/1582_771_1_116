package com.example.demo.service;

import com.example.demo.entity.Contract;

public interface ContractService {
    Contract saveContract(Contract contract);
    Contract getContract(Long id);
}
