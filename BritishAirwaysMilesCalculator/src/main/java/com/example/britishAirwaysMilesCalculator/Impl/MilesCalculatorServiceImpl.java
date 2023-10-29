package com.example.britishAirwaysMilesCalculator.Impl;

import com.example.britishAirwaysMilesCalculator.repository.MilesRepository;
import com.example.britishAirwaysMilesCalculator.service.MilesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilesCalculatorServiceImpl implements MilesCalculatorService {
    @Autowired
    MilesRepository milesRepository;
    @Override
    public Long calculateMiles(String customerId) {

        return milesRepository.calcMiles(customerId);
    }
}
