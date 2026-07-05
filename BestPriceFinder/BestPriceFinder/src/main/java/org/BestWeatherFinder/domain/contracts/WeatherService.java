package org.BestWeatherFinder.domain.contracts;

import org.BestWeatherFinder.domain.contracts.models.WeatherForecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;

import java.util.concurrent.CompletableFuture;

public interface WeatherService {
    WeatherForecast getWeatherForecast(City city);
    CompletableFuture<WeatherForecast> getWeatherForecastAsync(String city);
}
