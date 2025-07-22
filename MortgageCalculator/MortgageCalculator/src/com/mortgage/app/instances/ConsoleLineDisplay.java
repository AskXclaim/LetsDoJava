package com.mortgage.app.instances;

import com.mortgage.app.interfaces.Display;
import java.util.Currency;
import java.util.Locale;

import static java.lang.System.*;

public class ConsoleLineDisplay implements Display {
    private final Currency currency = Currency.getInstance(Locale.getDefault());

    @Override
    public void display(String content) {
        out.print(content);
    }

    @Override
    public void newLineDisplay(String content) {
        out.println(content);
    }

    @Override
    public void displayHeader(String headerText, char headerCharacter) {
        out.println();
        out.println(headerText);
        for (var i = 0; i < headerText.length(); i++) out.print(headerCharacter);
        out.println();
    }

    @Override
    public void displayMoney(String text, double amount) {
        var stringFormatter = text+" %s%s%n";
        out.printf(stringFormatter, currency.getSymbol(), String.format("%,.02f", amount));
    }


}
