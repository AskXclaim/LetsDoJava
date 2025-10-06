package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
