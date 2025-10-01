package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
