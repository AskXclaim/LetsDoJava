package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Iterable<Product>> findByCategoryId(Byte id);
}
