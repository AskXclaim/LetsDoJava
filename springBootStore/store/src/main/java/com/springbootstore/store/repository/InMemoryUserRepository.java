package com.springbootstore.store.repository;

import com.springbootstore.store.repository.interfaces.UserRepository;
import com.springbootstore.store.services.models.User;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepository {

    private HashMap<String,User> users = new HashMap<String,User>();
    @Override
    public void save(User user) throws Exception {
        if (user == null || user.email==null || user.email.isEmpty()) {
            throw new Exception("Email is null or empty");
        }

        users.put(user.email, user);
    }
}
