package org.BestWeatherFinder.infrastructure.services.models;

import lombok.Builder;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;
import org.BestWeatherFinder.infrastructure.services.weather.enums.Forecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.TemperatureUnit;

@Builder
public record WeatherForecast(
        String serviceProvider,
        City city,
        Forecast forecast,
        double temperature,
        TemperatureUnit temperatureUnit
) {
}
