package com.flightbrokersimulator.apis;

import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public class FlightDetail {
    private final String broker;
    private final String airline;
    private final Double price;

    public FlightDetail(String broker, String airline, Double price) {
        this.broker = broker;
        this.airline = airline;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("From '%s' there is %s %s flight for %s%.2f",
                normalize(broker), getArticle(airline), normalize(airline), getLocalCurrencySymbol(), price);
    }

    private String normalize(String value) {
        if (isNullOrEmpty(value))
            return "";

        value = value.trim().toLowerCase();
        var firstCharacter = value.substring(0, 1).toUpperCase();
        return firstCharacter + value.substring(1);
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private String getArticle(String value) {
        if (isNullOrEmpty(value)) return "a";

        String[] englishVowels = {"a", "e", "i", "o", "u"};
        var firstCharacter = value.trim().substring(0, 1).toLowerCase();
        if (Arrays.asList(englishVowels).contains(firstCharacter))
            return "an";

        return "a";
    }

    private String getLocalCurrencySymbol() {
        return Currency.getInstance(Locale.getDefault()).getSymbol();
    }
}
