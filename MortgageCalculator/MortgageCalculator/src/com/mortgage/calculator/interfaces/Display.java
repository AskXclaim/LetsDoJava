package com.mortgage.calculator.interfaces;

public interface Display {
    void display(String content);

    void newLineDisplay(String content);

    void displayHeader(String headerText, char headerCharacter);

    void displayMoney(String text, double amount);
}
