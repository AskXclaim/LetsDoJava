package com.springbootstore.store;

import com.springbootstore.store.services.OrderService;
import com.springbootstore.store.services.UserService;
import com.springbootstore.store.services.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        SpringApplication.run(StoreApplication.class, args);

//        var applicationContext = SpringApplication.run(StoreApplication.class);
//        var notificationSender = applicationContext.getBean( NotificationSender.class);
//        notificationSender.sendNotification("Hello World!");

//        var context = SpringApplication.run(StoreApplication.class);
//        var orderService = context.getBean(OrderService.class);
//        orderService.placeOrder(200);

        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class);
        var userService= context.getBean(UserService.class);
        userService.registerUser(new User(1,"Kola","some@email.com","password01"));
        userService.registerUser(new User(2,"Cola","some2@email.com","password02"));
    }

}
