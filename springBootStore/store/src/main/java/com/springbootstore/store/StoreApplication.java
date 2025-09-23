package com.springbootstore.store;

import com.springbootstore.store.entities.Address;
import com.springbootstore.store.entities.Product;
import com.springbootstore.store.entities.User;
import com.springbootstore.store.repositories.UserRepository;
import com.springbootstore.store.services.ProductService;
import com.springbootstore.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

import static java.lang.System.out;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(StoreApplication.class, args);
        var productService = context.getBean(ProductService.class);
        productService.deleteProduct("Product 2");
        //addUser(context);
        //addProductToWishlist(context);

        addProduct(context);

//        workWithUserEntities(context);
//        addUser(context);
        addUserWithRelatedEntities(context);
    }

    private static void addProductToWishlist(ConfigurableApplicationContext context) {
        var userService = context.getBean(UserService.class);
        userService.addProductToFavourite(1L, "Product 2");
    }

    private static void addProduct(ConfigurableApplicationContext context) {
        var productService = context.getBean(ProductService.class);
        var product = Product.builder().name("Product 3").price(BigDecimal.valueOf(100)).build();
        productService.addProduct(product, "phones");
    }

    private static void addUserWithRelatedEntities(ConfigurableApplicationContext context) {
        var repository = context.getBean(UserRepository.class);
        var user = User.builder().name("kola").email("another@email.com"). password("admin").build();
        var address = Address.builder().city("Leeds").postalZipCode("123456").street("Bridge Quarter").build();
        user.addAddress(address);
        repository.save(user);
        out.println(user);
    }

    private static void addUser(ConfigurableApplicationContext context) {
        var repository = context.getBean(UserRepository.class);
        var newUser = User.builder()
                .name("Kola2")
                .password("1234")
                .email("somepassword@some2.com")
                .build();
        repository.save(newUser);
    }

    private static void workWithUserEntities(ConfigurableApplicationContext context) {
        var userService = context.getBean(UserService.class);
        userService.showUserEntities();
        userService.showProfileEntity();
        // service.removeUserEntity(5L);
    }

}
