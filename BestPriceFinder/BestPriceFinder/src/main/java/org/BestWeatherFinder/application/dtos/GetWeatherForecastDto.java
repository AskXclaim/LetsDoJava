package org.BestWeatherFinder.application.dtos;

import lombok.Builder;

@Builder
public record GetWeatherForecastDto(
    String city,
    String forecast,
    double temperature,
    String temperatureUnit
) {}
