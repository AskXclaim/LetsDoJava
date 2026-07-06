package org.BestWeatherFinder.infrastructure.services.weather.bbcWeatherService;

import lombok.RequiredArgsConstructor;
import org.BestWeatherFinder.domain.contracts.WeatherService;
import org.BestWeatherFinder.infrastructure.services.models.WeatherForecast;
import org.BestWeatherFinder.infrastructure.services.message.contracts.MessageService;
import org.BestWeatherFinder.infrastructure.services.weather.WeatherServiceUtility;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class BbcWeatherService implements WeatherService {
    private final MessageService messageService;
    /**
     * Returns a weather forecast for the requested city.
     *
     * @param city city to fetch the forecast for
     * @return weather forecast
     */
    @Override
    public WeatherForecast getWeatherForecast(City city) {
        messageService.send("Getting data from BBC Weather Service...");
        return WeatherServiceUtility.getWeatherForecast("BBC",city, WeatherServiceUtility.getTemperature());
    }

    /**
     * Returns a weather forecast asynchronously for the requested city.
     *
     * @param city city to fetch the forecast for
     * @return future weather forecast
     */
    @Override
    public CompletableFuture<WeatherForecast> getWeatherForecastAsync(String city) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                WeatherServiceUtility.sleep();
            } catch (InterruptedException _) {
            }

            return getWeatherForecast(City.getCity(city));
        });
    }
}
