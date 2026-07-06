package org.BestWeatherFinder.domain.contracts;

import org.BestWeatherFinder.infrastructure.services.models.WeatherForecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;

import java.util.concurrent.CompletableFuture;

public interface WeatherService {
    WeatherForecast getWeatherForecast(City city);
    CompletableFuture<WeatherForecast> getWeatherForecastAsync(String city);
}
