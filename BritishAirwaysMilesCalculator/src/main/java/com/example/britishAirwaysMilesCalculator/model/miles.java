package com.example.britishAirwaysMilesCalculator.model;

import jakarta.persistence.Entity;


public class miles {
    private Long milesFlown;
    private String customerId;

    public Long getMilesFlown() {
        return milesFlown;
    }

    public void setMilesFlown(Long milesFlown) {
        this.milesFlown = milesFlown;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
