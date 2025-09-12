package com.springbootstore.store.services.interfaces;

public interface NotificationService {
    void send(String message, String emailOrPhone);
}
