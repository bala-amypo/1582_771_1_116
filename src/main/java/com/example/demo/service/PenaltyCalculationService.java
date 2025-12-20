package com.example.demo.service;

import java.util.List;

public interface PenaltyCalculationService {

    List<?> getCalculationsForContract(Long contractId);

}
