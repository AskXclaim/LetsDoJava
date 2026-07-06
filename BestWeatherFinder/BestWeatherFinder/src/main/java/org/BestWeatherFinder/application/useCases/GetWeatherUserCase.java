package org.BestWeatherFinder.application.useCases;

import lombok.RequiredArgsConstructor;
import org.BestWeatherFinder.application.dtos.GetWeatherForecastDto;
import org.BestWeatherFinder.application.mappers.WeatherMapper;
import org.BestWeatherFinder.domain.contracts.WeatherService;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class GetWeatherUserCase {
    private final WeatherService weatherService;

    public CompletableFuture<GetWeatherForecastDto> execute(String city) {
        return weatherService.getWeatherForecastAsync(city).thenApplyAsync(WeatherMapper.INSTANCE::toDto);
    }
}
