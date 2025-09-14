package com.springbootstore.store;

import com.springbootstore.store.services.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {
    private final NotificationService notificationService;
    NotificationSender(@Qualifier("smsNotificationService") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message, String emailOrPhone) {
        notificationService.send(message, emailOrPhone);
    }
}
