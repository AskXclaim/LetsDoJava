package org.BestWeatherFinder.application.mappers;

import org.BestWeatherFinder.application.dtos.GetWeatherForecastDto;
import org.BestWeatherFinder.domain.contracts.models.WeatherForecast;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    GetWeatherForecastDto toDto(WeatherForecast weatherForecast);
}
