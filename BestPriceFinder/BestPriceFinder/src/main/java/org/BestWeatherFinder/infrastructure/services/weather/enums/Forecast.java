package org.BestWeatherFinder.infrastructure.services.weather.enums;

import java.util.Random;

public enum Forecast {
    SUNNY,
    CLOUDY,
    RAINY;

    public static Forecast getForecast() {
        Random random = new Random();
        return Forecast.values()[random.nextInt(Forecast.values().length)];
    }
}
