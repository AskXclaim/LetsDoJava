package com.springbootstore.store.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @ToString.Exclude
    private Category category;

    @ManyToMany(mappedBy = "wishlist")
    private Set<User> users = new HashSet<>();

    public void addCategory(String categoryName) {
        if(categoryName==null || categoryName.isBlank()){
            throw new IllegalArgumentException("Category name cannot be null or blank");
        }
        this.category = Category.builder().name(categoryName.trim()).build();
    }
    public void addCategory(Category category) {
        if(category==null){
            throw new IllegalArgumentException("Category cannot be null");
        }
        this.category = category;
    }
}