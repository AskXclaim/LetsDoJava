package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface UserRepository extends JpaRepository<User, Long> {
    @Procedure("addUser")
    void addUser(String name, String password, String email);
}
