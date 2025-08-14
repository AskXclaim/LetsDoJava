package com.flightbrokersimulator.apis;

import com.flightbrokersimulator.Flight;
import com.flightbrokersimulator.apis.interfaces.FlightInformation;

import java.util.concurrent.CompletableFuture;

public class FlightScanner implements FlightInformation {
    @Override
    public FlightDetail getQuoteOfTheDay() {
        return Flight.getRandomFlightDetail(this);
    }

    @Override
    public CompletableFuture<FlightDetail> getQuoteOfTheDayAsync() throws InterruptedException {
        Thread.sleep(Flight.getRandomWholeNumber(1_000,5_000));
        return CompletableFuture.supplyAsync(()->Flight.getRandomFlightDetail(this));
    }
}
