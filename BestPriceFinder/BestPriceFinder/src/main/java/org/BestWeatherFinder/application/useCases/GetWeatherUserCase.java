package org.BestWeatherFinder.application.useCases;

import lombok.RequiredArgsConstructor;
import org.BestWeatherFinder.application.dtos.GetWeatherForecastDto;
import org.BestWeatherFinder.application.mappers.WeatherMapper;
import org.BestWeatherFinder.domain.contracts.WeatherService;

@RequiredArgsConstructor
public class GetWeatherUserCase {
    private final WeatherService weatherService;

    public GetWeatherForecastDto execute(String city) {
       return weatherService.getWeatherForecastAsync(city).thenApplyAsync(WeatherMapper.INSTANCE::toDto).join();
    }
}
