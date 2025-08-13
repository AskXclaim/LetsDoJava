package com.flightbrokersimulator.apis.interfaces;

import com.flightbrokersimulator.apis.FlightDetail;

import java.util.concurrent.CompletableFuture;

public interface FlightInformation {
    FlightDetail getQuoteOfTheDay();

    CompletableFuture<FlightDetail> getQuoteOfTheDayAsync() throws InterruptedException;
}
