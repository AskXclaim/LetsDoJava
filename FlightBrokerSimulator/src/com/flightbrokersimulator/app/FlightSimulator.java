package com.flightbrokersimulator.app;

import com.flightbrokersimulator.apis.FlightDetail;
import com.flightbrokersimulator.apis.FlightScanner;
import com.flightbrokersimulator.apis.FlyAway;
import com.flightbrokersimulator.apis.SkyScanner;
import com.flightbrokersimulator.apis.interfaces.FlightInformation;
import com.flightbrokersimulator.app.interfaces.Simulatable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class FlightSimulator implements Simulatable {
    @Override
    public void simulate() {
        out.println("Welcome to FlightPrice Simulator!");
        var flightBrokers = new ArrayList<FlightInformation>();
        flightBrokers.add(new SkyScanner());
        flightBrokers.add(new FlightScanner());
        flightBrokers.add(new FlyAway());
        var futures = new ArrayList<CompletableFuture<FlightDetail>>();
        var started = LocalDateTime.now();
        for (var flightBroker : flightBrokers) {
            var future = getQuote(flightBroker);
            futures.add(future);
        }

        var activatedFutures = futures.stream()
                .map(future -> future.thenAccept(out::println))
                .toList();

        CompletableFuture.allOf(activatedFutures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var duration = Duration.between(started, LocalDateTime.now());
                    out.println("Retrieved all quotes in approximately " + duration.toMillis() + " msecs");
                });
    }

    private CompletableFuture<FlightDetail> getQuote(FlightInformation flightBroker) {
        try {
            out.println("Getting a quote from " + flightBroker.getClass().getSimpleName());
            return flightBroker.getQuoteOfTheDayAsync();

        } catch (InterruptedException e) {
            out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return null;
    }
}
