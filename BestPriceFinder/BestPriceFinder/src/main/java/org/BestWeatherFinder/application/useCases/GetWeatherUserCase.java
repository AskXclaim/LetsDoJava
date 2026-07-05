package org.BestWeatherFinder.application.useCases;

import lombok.RequiredArgsConstructor;
import org.BestWeatherFinder.application.dtos.GetWeatherForecastDto;
import org.BestWeatherFinder.application.mappers.WeatherMapper;
import org.BestWeatherFinder.domain.contracts.WeatherService;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;

@RequiredArgsConstructor
public class GetWeatherUserCase {
    private final WeatherService weatherService;

    public GetWeatherForecastDto execute(String city) {
        var weatherForecast = weatherService.getWeatherForecastAsync(city).join();
        return WeatherMapper.INSTANCE.toDto(weatherForecast);
    }
}
