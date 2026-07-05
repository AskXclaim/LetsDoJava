package org.BestWeatherFinder.infrastructure.services.weather;

import org.BestWeatherFinder.domain.contracts.WeatherService;
import org.BestWeatherFinder.domain.contracts.models.WeatherForecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;
import org.BestWeatherFinder.infrastructure.services.weather.enums.Forecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.TemperatureUnit;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class BbcWeatherService implements WeatherService {
    /**
     * Returns a weather forecast for the requested city.
     *
     * @param city city to fetch the forecast for
     * @return weather forecast
     */
    @Override
    public WeatherForecast getWeatherForecast(City city) {

        var temperature = Math.round(ThreadLocalRandom.current().nextDouble(-459.67, 212) * 100.0) / 100.0;

        if (City.isValidCity(city)) {
            return WeatherForecast.builder()
                    .city(City.LEEDS)
                    .forecast(Forecast.getForecast())
                    .temperature(temperature)
                    .temperatureUnit(TemperatureUnit.getTemperatureUnit(temperature))
                    .build();
        }

        return WeatherForecast.builder()
                .city(city)
                .forecast(Forecast.getForecast())
                .temperature(temperature)
                .temperatureUnit(TemperatureUnit.getTemperatureUnit(temperature))
                .build();
    }

    /**
     * Returns a weather forecast asynchronously for the requested city.
     *
     * @param city city to fetch the forecast for
     * @return future weather forecast
     */
    @Override
    public CompletableFuture<WeatherForecast> getWeatherForecastAsync(String city) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException _) {
            }

            return getWeatherForecast(City.getCity(city));
        });
    }
}
