package com.springbootstore.apifundamental.services.interfaces;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.entities.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Iterable<Product>> getAllProducts(String sortBy, PageRequest pageRequest);

    Optional<Product> getProductById(Long id);

    Optional<Iterable< Product>> getProductByCategoryId(Byte id);
}
