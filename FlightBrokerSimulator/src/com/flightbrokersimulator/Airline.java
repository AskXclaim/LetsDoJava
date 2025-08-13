package com.flightbrokersimulator;

import java.util.concurrent.ThreadLocalRandom;

public enum Airline {
    BRITISH_AIRWAYS("British Airways"),
    VIRGIN("Virgin"),
    KLM("KLM");

    private final String airlineName;

    Airline(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return this.airlineName;
    }

    public static Airline getRandomAirline() {
        Airline[] airlines = Airline.values();
        var index = ThreadLocalRandom.current().nextInt(0, airlines.length);
        return airlines[index ];
    }
}
