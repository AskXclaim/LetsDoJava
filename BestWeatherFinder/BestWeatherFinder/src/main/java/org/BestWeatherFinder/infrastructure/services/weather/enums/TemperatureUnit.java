package org.BestWeatherFinder.infrastructure.services.weather.enums;

public enum TemperatureUnit {
    CELSIUS,
    FAHRENHEIT;

    public static TemperatureUnit getTemperatureUnit(double temperature) {
       if (temperature < 0 || temperature > 100) {
           return TemperatureUnit.FAHRENHEIT;
       } else {
           return TemperatureUnit.CELSIUS;
       }
    }
}
