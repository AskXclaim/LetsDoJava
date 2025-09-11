package com.springbootstore.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        SpringApplication.run(StoreApplication.class, args);

        var applicationContext = SpringApplication.run(StoreApplication.class);
        var notificationSender = applicationContext.getBean( NotificationSender.class);
        notificationSender.sendNotification("Hello World!");
    }

}
