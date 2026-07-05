package org.BestWeatherFinder.application.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
public class GetWeatherForecastDto {
    private String city;
    private String forecast;
    private double temperature;
    private String temperatureUnit;

    @Override
    public String toString() {
        return "city='" + city + '\'' +
                ", forecast='" + forecast + '\'' +
                ", temperature=" + temperature +
                ", temperatureUnit='" + temperatureUnit;
    }
}
