package com.springbootstore.store.services;

import com.springbootstore.store.entities.Category;
import com.springbootstore.store.entities.Product;
import com.springbootstore.store.repositories.CategoryRepository;
import com.springbootstore.store.repositories.ProductRepository;
import com.springbootstore.store.utilities.StringUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.experimental.ExtensionMethod;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import static java.lang.System.*;

@AllArgsConstructor
@ExtensionMethod(StringUtils.class)
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void addProduct(Product product, String categoryName) {
        var availableProduct = productRepository.findByNameIgnoreCase(product.getName().trim()).orElse(null);
        if (availableProduct == null) {
            var category = categoryRepository.findCategoryByNameIgnoreCase(categoryName.trim()).orElse(null);
            if (category == null) {
                var newCategory = Category.builder().name(categoryName.toProperCase()).build();
                product.addCategory(newCategory);
                var products = new HashSet<Product>();
                products.add(product);
                newCategory.setProducts(products);
                categoryRepository.save(newCategory);
            } else {
                product.setCategory(category);
                productRepository.save(product);
            }
            out.println(product.getName() + " has been added to category " + categoryName);
            out.println(product);
        } else
            out.println("Product with name: " + product.getName() + " already exists");
    }

}
