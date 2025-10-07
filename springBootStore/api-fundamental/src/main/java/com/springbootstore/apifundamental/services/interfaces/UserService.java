package com.springbootstore.apifundamental.services.interfaces;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.entities.User;

import java.util.Optional;

public interface UserService {

    boolean doesAnyUserExist();

    void addUser(User user);

    Iterable<User> findAll(String sortBy, PageRequest pageRequest);

    Optional<User> findById(Long id);
}
