package com.flightbrokersimulator;

import com.flightbrokersimulator.app.FlightSimulator;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        try {
            var simulator = new FlightSimulator();
            simulator.simulate();
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            out.println(e.getMessage());
        }
    }
}
