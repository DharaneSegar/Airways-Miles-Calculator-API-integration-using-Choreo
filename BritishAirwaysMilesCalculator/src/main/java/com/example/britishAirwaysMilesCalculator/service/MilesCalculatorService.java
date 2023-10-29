package com.example.britishAirwaysMilesCalculator.service;

import org.springframework.stereotype.Service;

@Service
public interface MilesCalculatorService {
    Long calculateMiles(String customerId);
}
