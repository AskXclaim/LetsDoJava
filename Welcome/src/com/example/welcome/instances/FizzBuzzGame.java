package com.example.welcome.instances;

import com.example.welcome.interfaces.Display;
import com.example.welcome.interfaces.FizzBuzzValidator;
import com.example.welcome.interfaces.Game;
import com.example.welcome.interfaces.Input;

import java.util.Objects;

public class FizzBuzzGame implements Game {
    private final Display display;
    private final Input input;
    private final FizzBuzzValidator validator;

    public FizzBuzzGame(Display display, Input input, FizzBuzzValidator validator) {
        this.display = display;
        this.input = input;
        this.validator = validator;
    }

    @Override
    public void startGame(String startMessage) {
        start(startMessage);
    }

    private void start(String startMessage) {
        if (Objects.isNull(startMessage) || startMessage.isEmpty())
            this.display.showOnNewLine("Welcome to FizzBuzz!");

        this.display.showOnNewLine("When you are ready to end the game please type 'quit'");

        playGame();

    }

    private void playGame() {
        do {
            this.display.show("Enter a number: ");
            var valueEntered = this.input.getInput().trim().toLowerCase();

            if (valueEntered.equals("quit")) {
                this.display.showOnNewLine("Bye bye!");
                return;
            }
            if (!validator.isNumber(valueEntered)) {
                this.display.showOnNewLine("Invalid entry, only numbers are accepted");
                continue;
            }
            var number = Integer.parseInt(valueEntered);
            this.display.showOnNewLine(getResult(number));
        } while (true);
    }

    private String getResult(int value) {
        if (value % 3 == 0 && value % 5 == 0) return "FizzBuzz";
        if (value % 3 == 0) return "Fizz";
        if (value % 5 == 0) return "Buzz";
        return "not fizz or buzz";
    }


}
