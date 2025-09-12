package com.springbootstore.store;

import com.springbootstore.store.repository.InMemoryUserRepository;
import com.springbootstore.store.repository.interfaces.UserRepository;
import com.springbootstore.store.services.OrderService;
import com.springbootstore.store.services.UserService;
import com.springbootstore.store.services.interfaces.NotificationService;
import com.springbootstore.store.services.interfaces.PaymentService;
import com.springbootstore.store.services.notifications.EmailNotificationService;
import com.springbootstore.store.services.payments.PaypalPaymentService;
import com.springbootstore.store.services.payments.StripePaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${stripe.apiUrl}")
    private String stripeApiUrl;

    @Value("${paypal.apiUrl}")
    private String paypalApiUrl;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    @Bean
    public OrderService orderService() {
        if (!isEmptyOrWhitespace(stripeApiUrl)) {
            return new OrderService(stripe());
        }
        if (!isEmptyOrWhitespace(paypalApiUrl)) {
            return new OrderService(paypal());
        }

        throw new RuntimeException("API URL is empty");
    }

    @Bean
    public NotificationService emailNotificationService() {
        return new EmailNotificationService();
    }

    @Bean
    public UserRepository inMemoryUserRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserService userService() {
        return new UserService(emailNotificationService(), inMemoryUserRepository());
    }

    private boolean isEmptyOrWhitespace(String value) {
        return value == null || value.trim().isEmpty();
    }
}
