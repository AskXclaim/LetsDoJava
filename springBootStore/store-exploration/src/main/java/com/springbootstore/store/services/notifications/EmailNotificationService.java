package com.springbootstore.store.services.notifications;

import com.springbootstore.store.services.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Value;

import static java.lang.System.*;

//@Service("emailNotificationService")
//@Primary
public class EmailNotificationService implements NotificationService {
    @Value("${spring.application.host}")
    private String host;
    @Value("${spring.application.port}")
    private String port;

    @Override
    public void send(String message, String emailOrPhone) {
        if (emailOrPhone == null || emailOrPhone.isEmpty()) {
            out.println("Invalid email address");
            throw new IllegalArgumentException("Invalid email address");
        }
        out.println("Email with message:'" + message + "' is sent to email: " + emailOrPhone);
        out.println("Host: " + host+ ", Port:"+port);
    }
}
