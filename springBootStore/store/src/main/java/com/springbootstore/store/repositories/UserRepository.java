package com.springbootstore.store.repositories;

import com.springbootstore.store.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findFirstBy();

    Optional<User> findUserById(long id);
}
