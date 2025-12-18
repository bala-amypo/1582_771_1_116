package com.example.demo.service;

import com.example.demo.entity.Contract;
import java.util.List;

public interface ContractService {
    Contract create(Contract contract);
    Contract getById(Long id);
    List<Contract> getAll();
}
