package com.flightbrokersimulator.app;

import com.flightbrokersimulator.apis.FlightScanner;
import com.flightbrokersimulator.apis.FlyAway;
import com.flightbrokersimulator.apis.SkyScanner;
import com.flightbrokersimulator.apis.interfaces.FlightInformation;
import com.flightbrokersimulator.app.interfaces.Simulatable;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static java.lang.System.out;

public class FlightSimulator implements Simulatable {
    @Override
    public void simulate() {
        out.println("Welcome to FlightPrice Simulator!");
        var flightBrokers = new ArrayList<FlightInformation>();
        flightBrokers.add(new SkyScanner());
        flightBrokers.add(new FlightScanner());
        flightBrokers.add(new FlyAway());
        for (var flightBroker : flightBrokers) getQuote(flightBroker);
    }

    private void getQuote(FlightInformation flightBroker) {
        CompletableFuture.runAsync(() -> {
            try {
                out.println("Getting a quote from " + flightBroker.getClass().getSimpleName());
                var future = flightBroker.getQuoteOfTheDayAsync();
                future.thenAccept(quote -> out.println(quote.toString()));
            } catch (InterruptedException e) {
                out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        });
    }
}
