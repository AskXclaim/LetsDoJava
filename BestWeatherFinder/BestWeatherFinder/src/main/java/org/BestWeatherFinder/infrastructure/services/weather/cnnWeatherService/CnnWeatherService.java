package org.BestWeatherFinder.infrastructure.services.weather.cnnWeatherService;

import lombok.RequiredArgsConstructor;
import org.BestWeatherFinder.domain.contracts.WeatherService;
import org.BestWeatherFinder.infrastructure.services.models.WeatherForecast;
import org.BestWeatherFinder.infrastructure.services.message.contracts.MessageService;
import org.BestWeatherFinder.infrastructure.services.weather.WeatherServiceUtility;
import org.BestWeatherFinder.infrastructure.services.weather.enums.City;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class CnnWeatherService implements WeatherService {
    private final MessageService messageService;

    /**
     * Retrieves the weather forecast for a specified city.
     * This method sends a message indicating the source of data and then fetches the weather forecast.
     *
     * @param city the city for which the weather forecast needs to be retrieved.
     *             The city must be a predefined valid city in the system (e.g., Leeds, Liverpool, Manchester).
     * @return the WeatherForecast for the specified city, containing details such as city, forecast, temperature, and temperature unit.
     */
    @Override
    public WeatherForecast getWeatherForecast(City city) {
        messageService.send("Getting data from CNN Weather Service...");
        double temperature = WeatherServiceUtility.getTemperature();

        return WeatherServiceUtility.getWeatherForecast("CNN", city, temperature);
    }

    /**
     * Asynchronously retrieves the weather forecast for a specified city.
     * This method uses a separate thread to fetch the weather forecast.
     *
     * @param city the name of the city for which the weather forecast is to be retrieved.
     *             The city name must be a valid city (e.g., Leeds, Liverpool, Manchester).
     * @return a CompletableFuture containing the WeatherForecast for the specified city.
     * The CompletableFuture completes when the weather data is retrieved.
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
