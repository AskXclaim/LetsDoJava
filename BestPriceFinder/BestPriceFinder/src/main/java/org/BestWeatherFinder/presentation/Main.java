package org.BestWeatherFinder.presentation;

import org.BestWeatherFinder.application.useCases.GetWeatherUserCase;
import org.BestWeatherFinder.infrastructure.services.weather.BbcWeatherService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Best Weather Finder!");
        var getWeatherUserCase = new GetWeatherUserCase(new BbcWeatherService()).execute("Leeds");
        System.out.println(getWeatherUserCase);
    }
}
