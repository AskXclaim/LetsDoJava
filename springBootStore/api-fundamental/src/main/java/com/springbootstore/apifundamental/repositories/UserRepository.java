package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
