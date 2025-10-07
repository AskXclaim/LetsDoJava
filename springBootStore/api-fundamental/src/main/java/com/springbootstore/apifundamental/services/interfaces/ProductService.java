package com.springbootstore.apifundamental.services.interfaces;

import com.springbootstore.apifundamental.entities.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Iterable<Product>>  getAllProducts();
    Optional<Product> getProductById(Long id);
}
