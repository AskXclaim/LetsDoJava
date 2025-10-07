package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
