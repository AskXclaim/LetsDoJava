package org.BestWeatherFinder.domain.contracts.models;

import lombok.Builder;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;
import org.BestWeatherFinder.infrastructure.services.weather.enums.Forecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.TemperatureUnit;

@Builder
public record WeatherForecast(
    City city,
    Forecast forecast,
    double temperature,
    TemperatureUnit temperatureUnit
) {}
