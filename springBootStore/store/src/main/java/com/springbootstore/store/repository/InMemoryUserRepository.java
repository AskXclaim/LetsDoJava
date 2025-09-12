package com.springbootstore.store.repository;

import com.springbootstore.store.repository.interfaces.UserRepository;
import com.springbootstore.store.services.models.User;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepository {

    private final HashMap<String, User> users = new HashMap<>();

    @Override
    public void save(User user) throws Exception {
        validateUser(user);
        users.put(user.getEmail(), user);
    }

    private void validateUser(User user) throws Exception {
        if (user == null || user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new Exception("Email is null or empty");
        }
        if (users.containsKey(user.getEmail())) {
            throw new Exception("User already exists");
        }
    }
}
