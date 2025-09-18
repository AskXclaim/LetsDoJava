package com.springbootstore.store.repositories;

import com.springbootstore.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findFirstBy();
}
