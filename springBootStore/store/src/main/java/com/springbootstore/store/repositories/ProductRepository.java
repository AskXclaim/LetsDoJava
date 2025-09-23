package com.springbootstore.store.repositories;

import com.springbootstore.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByNameIgnoreCase(String productName);
}
