package org.BestWeatherFinder.infrastructure.services.weather;

import org.BestWeatherFinder.domain.exceptions.ServiceUnavailableException;
import org.BestWeatherFinder.infrastructure.services.models.WeatherForecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;
import org.BestWeatherFinder.infrastructure.services.weather.enums.Forecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.TemperatureUnit;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class providing methods for interacting with weather-related services.
 * This class contains methods to retrieve weather forecasts, generate random temperatures,
 * and introduce delays to simulate real service interactions.
 * The methods provided are static and can be used without instantiating the class.
 */
public final class WeatherServiceUtility {

    /**
     * Retrieves a weather forecast for the specified service provider and city, along with the given temperature.
     * If the provided city is invalid, a random city is selected instead.
     * The returned forecast includes the provider's name, the city, the weather condition,
     * the temperature, and its corresponding temperature unit.
     *
     * @param serviceProvider the name of the weather service provider
     * @param city the city for which the weather forecast is retrieved
     * @param temperature the temperature value to include in the forecast
     * @return a WeatherForecast object containing the service provider, city, forecast details, temperature, and temperature unit
     */
    public static WeatherForecast getWeatherForecast(String serviceProvider,City city, double temperature) {
        if (!City.isValidCity(city)) {
            return WeatherForecast.builder()
                    .serviceProvider(serviceProvider)
                    .city(City.getRandomCity())
                    .forecast(Forecast.getForecast())
                    .temperature(temperature)
                    .temperatureUnit(TemperatureUnit.getTemperatureUnit(temperature))
                    .build();
        }

        return WeatherForecast.builder()
                .serviceProvider(serviceProvider)
                .city(city)
                .forecast(Forecast.getForecast())
                .temperature(temperature)
                .temperatureUnit(TemperatureUnit.getTemperatureUnit(temperature))
                .build();
    }

    /**
     * Retrieves a randomly generated temperature value within a predefined range.
     * The range spans from absolute zero (-459.67°F) to the boiling point of water (212°F).
     * The returned value is rounded to two decimal places for precision.
     *
     * @return a double representing the randomly generated temperature in degrees Fahrenheit.
     */
    public static double getTemperature() {
        return Math.round(ThreadLocalRandom.current().nextDouble(-459.67, 212) * 100.0) / 100.0;
    }
    /**
     * Introduces a random delay to simulate variability in service response times.
     * The delay duration is randomly selected between 1 and 5 seconds.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    public static void sleep() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
    }

    /**
     * Randomly throws a ServiceUnavailableException to simulate service instability.
     * @param serviceName the name of the service to simulate failure for
     */
    public static void simulateFailure(String serviceName) {
        if (ThreadLocalRandom.current().nextInt(0, 4) == 0) { // 25% chance of failure
            throw new ServiceUnavailableException(serviceName);
        }
    }
}
