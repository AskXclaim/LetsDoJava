package org.BestWeatherFinder.infrastructure.services.message;

import org.BestWeatherFinder.infrastructure.services.message.contracts.MessageService;

public class ConsoleMessageService implements MessageService {
    /**
     * @param message
     */
    @Override
    public void send(String message) {
        IO.println(message);
    }
}
