package com.example.welcome;

import com.example.welcome.instances.ConsoleDisplay;
import com.example.welcome.instances.ConsoleInput;
import com.example.welcome.instances.FizzBuzzGame;
import com.example.welcome.instances.FizzBuzzValueValidator;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        out.println("Hello World!");

        var fizzBuzzGame = new FizzBuzzGame(new ConsoleDisplay(), new ConsoleInput(), new FizzBuzzValueValidator());
        fizzBuzzGame.startGame("");
    }
}
