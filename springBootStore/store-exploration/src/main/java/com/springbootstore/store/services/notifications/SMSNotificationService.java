package com.springbootstore.store.services.notifications;

import com.springbootstore.store.services.interfaces.NotificationService;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@Service("smsNotificationService")
public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String message, String emailOrPhone) {
        if (emailOrPhone == null || emailOrPhone.isEmpty()) {
            out.println("Invalid phone number");
            throw new IllegalArgumentException("Invalid phone number");
        }
        out.println("SMS with message:'" + message + "' is sent to " + emailOrPhone);
    }
}
