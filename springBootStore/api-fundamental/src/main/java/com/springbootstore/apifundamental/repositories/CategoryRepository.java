package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
