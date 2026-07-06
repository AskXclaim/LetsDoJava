package org.BestWeatherFinder.domain.exceptions;

public class ServiceUnavailableException extends WeatherFinderException {
    public ServiceUnavailableException(String serviceName) {
        super(serviceName + " is temporarily unavailable");
    }
}
