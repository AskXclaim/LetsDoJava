package com.springbootstore.store.services;

import com.springbootstore.store.entities.Category;
import com.springbootstore.store.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@AllArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        var categories = categoryRepository.findCategoryByNameIgnoreCase(category.getName().trim()).orElse(null);
        if (categories == null) {
            categoryRepository.save(category);
            out.println("Category " + category.getName() + " created");
            out.println(category);
        }
        else
            out.println("Category with name " + category.getName() + " already exists");

    }
}
