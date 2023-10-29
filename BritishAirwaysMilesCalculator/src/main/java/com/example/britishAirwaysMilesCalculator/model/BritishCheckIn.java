package com.example.britishAirwaysMilesCalculator.model;

import jakarta.persistence.*;

@Entity
public class BritishCheckIn {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String bookReference;

    private String customerId;

    private String flightNumber;
    private String seatNumber;
    private String passengerName;

    private String fromWhere;

    private String whereTo;
    private float flightDistance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookReference() {
        return bookReference;
    }

    public void setBookReference(String bookReference) {
        this.bookReference = bookReference;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getWhereTo() {
        return whereTo;
    }

    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }

    public float getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(float flightDistance) {
        this.flightDistance = flightDistance;
    }
}
