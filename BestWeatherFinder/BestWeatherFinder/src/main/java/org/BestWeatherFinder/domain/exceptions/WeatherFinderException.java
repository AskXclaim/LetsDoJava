package org.BestWeatherFinder.domain.exceptions;

public class WeatherFinderException extends RuntimeException {
    public WeatherFinderException(String message) {
        super(message);
    }

    public WeatherFinderException(String message, Throwable cause) {
        super(message, cause);
    }
}
