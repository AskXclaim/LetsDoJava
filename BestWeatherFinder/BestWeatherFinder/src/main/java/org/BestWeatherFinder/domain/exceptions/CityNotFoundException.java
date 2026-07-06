package org.BestWeatherFinder.domain.exceptions;

public class CityNotFoundException extends WeatherFinderException {
    public CityNotFoundException(String city) {
        super("City not found: " + city);
    }
}
