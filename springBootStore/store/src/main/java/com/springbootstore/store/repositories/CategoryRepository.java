package com.springbootstore.store.repositories;

import com.springbootstore.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Optional<Category> findFirstBy();

    Optional<Category> findCategoryByNameIgnoreCase(String categoryName);

    Optional<Category> findCategoryById(Byte id);
}
