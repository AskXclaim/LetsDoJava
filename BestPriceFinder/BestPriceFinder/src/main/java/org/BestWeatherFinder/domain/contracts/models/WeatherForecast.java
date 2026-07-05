package org.BestWeatherFinder.domain.contracts.models;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;
import org.BestWeatherFinder.infrastructure.services.weather.enums.Forecast;
import org.BestWeatherFinder.infrastructure.services.weather.enums.TemperatureUnit;

@AllArgsConstructor
@Getter
@Builder
public class WeatherForecast {
    private City city;
    private Forecast forecast;
    private double temperature;
    private TemperatureUnit temperatureUnit;
}
