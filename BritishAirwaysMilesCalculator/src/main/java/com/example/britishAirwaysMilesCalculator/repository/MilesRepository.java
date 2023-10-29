package com.example.britishAirwaysMilesCalculator.repository;

import com.example.britishAirwaysMilesCalculator.model.BritishCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MilesRepository extends JpaRepository<BritishCheckIn,Integer> {
    @Query(value = "SELECT sum(flightDistance) FROM BritishCheckIn c WHERE customerId = :customerId")
    public Long calcMiles(@Param("customerId") String customerId);

}
