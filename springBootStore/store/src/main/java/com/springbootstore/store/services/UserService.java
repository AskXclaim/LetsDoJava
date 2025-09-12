package com.springbootstore.store.services;

import com.springbootstore.store.repository.interfaces.UserRepository;
import com.springbootstore.store.services.interfaces.NotificationService;
import com.springbootstore.store.services.models.User;

public class UserService {

    private final NotificationService notificationService;
    private final UserRepository userRepository;

    public UserService(NotificationService notificationService, UserRepository userRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }

    public void registerUser(User user){
        try {
            userRepository.save(user);
            notificationService.send("User with name:" +user.name+" created","some@email.com");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
