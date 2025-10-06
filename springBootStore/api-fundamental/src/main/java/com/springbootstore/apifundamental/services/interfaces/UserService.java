package com.springbootstore.apifundamental.services.interfaces;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.entities.User;

public interface UserService {
    Iterable<User> findAll(String sortBy, PageRequest pageRequest);
}
