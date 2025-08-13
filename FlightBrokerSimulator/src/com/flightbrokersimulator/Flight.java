package com.flightbrokersimulator;

import com.flightbrokersimulator.apis.FlightDetail;
import com.flightbrokersimulator.apis.interfaces.FlightInformation;

import java.util.concurrent.ThreadLocalRandom;

public class Flight {
    private Flight() {
    }

    public static double getRandomPrice(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static FlightDetail getRandomFlightDetail(FlightInformation flightInformation) {
        var airlineName = Airline.getRandomAirline().getAirlineName();

        return new FlightDetail(flightInformation.getClass().getSimpleName(), airlineName, getRandomPrice(1, 200));
    }

    public static int getRandomWholeNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
