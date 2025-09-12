package com.springbootstore.store.repository.interfaces;

import com.springbootstore.store.services.models.User;

public interface UserRepository {
    void save(User user) throws Exception;
}
