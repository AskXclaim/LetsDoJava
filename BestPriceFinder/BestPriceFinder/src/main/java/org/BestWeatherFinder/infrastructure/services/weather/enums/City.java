package org.BestWeatherFinder.infrastructure.services.weather.enums;

public enum City {
    LEEDS,
    LIVERPOOL,
    MANCHESTER;

   public static boolean isValidCity(City city) {
       return (city == LEEDS) || (city == LIVERPOOL) || (city == MANCHESTER);
   }
   private static boolean isValidCity(String city) {
       return (city.toUpperCase().equals(LEEDS.name())) || (city.toUpperCase().equals(LIVERPOOL.name())) || (city.toUpperCase().equals(MANCHESTER.name()));
   }
   public static City getCity(String city) {
       if (City.isValidCity(city.toUpperCase()) ) {
           return City.valueOf(city.toUpperCase());
       }
       throw new IllegalArgumentException("Invalid city");
   }
}
