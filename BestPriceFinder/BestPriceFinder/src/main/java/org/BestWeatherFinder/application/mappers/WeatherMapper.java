package org.BestWeatherFinder.application.mappers;

import org.BestWeatherFinder.application.dtos.GetWeatherForecastDto;
import org.BestWeatherFinder.domain.contracts.models.WeatherForecast;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(target = "city", expression = "java(String.valueOf(weatherForecast.getCity()))")
    @Mapping(target = "forecast", expression = "java(String.valueOf(weatherForecast.getForecast()))")
    @Mapping(target = "temperatureUnit", expression = "java(String.valueOf(weatherForecast.getTemperatureUnit()))")
    GetWeatherForecastDto toDto(WeatherForecast weatherForecast);
}
