package com.example.britishAirwaysMilesCalculator.controller;
import com.example.britishAirwaysMilesCalculator.model.MilesRequest;
import com.example.britishAirwaysMilesCalculator.model.miles;
import com.example.britishAirwaysMilesCalculator.service.MilesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/britishairways/miles")
public class MilesCalculatorController {

    @Autowired
    MilesCalculatorService milesService;

    @PostMapping(path="/",produces = MediaType.APPLICATION_XML_VALUE)
    public miles calcMiles(@RequestBody MilesRequest milesRequest) {
        Long totalMiles =  milesService.calculateMiles(milesRequest.getCustomerId());
        miles miles = new miles();

        if(totalMiles ==  null){
            miles.setCustomerId("null");
            miles.setMilesFlown(0L);
        }

        else{
            miles.setMilesFlown(totalMiles);
            miles.setCustomerId(milesRequest.getCustomerId());

        }


        System.out.println(miles);

        return miles;
    }

}
