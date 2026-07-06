package org.BestWeatherFinder.presentation;

import org.BestWeatherFinder.application.useCases.GetWeatherUserCase;
import org.BestWeatherFinder.infrastructure.services.message.ConsoleMessageService;
import org.BestWeatherFinder.infrastructure.services.weather.bbcWeatherService.BbcWeatherService;
import org.BestWeatherFinder.infrastructure.services.weather.cnnWeatherService.CnnWeatherService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import static java.lang.IO.*;
import static java.lang.System.out;

public class Main {
    static void main() {
        out.println("Hello and welcome to Best Weather Finder!");

        var bbcWeatherService = new BbcWeatherService(new ConsoleMessageService());
        var cnnWeatherService = new CnnWeatherService(new ConsoleMessageService());
        var bbcUserCase = new GetWeatherUserCase(bbcWeatherService);
        var cnnUserCase = new GetWeatherUserCase(cnnWeatherService);

        var started = LocalDateTime.now();
        CompletableFuture.allOf(
                        bbcUserCase.execute("Leeds")
                                .thenAcceptAsync(out::println)
                                .exceptionally(ex -> {
                                    System.err.println("Error fetching weather from BBC: " + ex.getCause().getMessage());
                                    return null;
                                }),
                        cnnUserCase.execute("Liverpool")
                                .thenAcceptAsync(out::println)
                                .exceptionally(ex -> {
                                    System.err.println("Error fetching weather from CNN: " + ex.getCause().getMessage());
                                    return null;
                                }))
                .thenRun(() -> {
                    println("All requests completed!");
                    var finished = LocalDateTime.now();
                    println("Duration: " + Duration.between(started, finished).toMillis() + "ms");
                }).join();

    }
}
