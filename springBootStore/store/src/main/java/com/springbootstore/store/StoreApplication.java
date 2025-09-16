package com.springbootstore.store;

import com.springbootstore.store.entities.Address;
import com.springbootstore.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        SpringApplication.run(StoreApplication.class, args);

        var user = User.builder().name("kola").password("admin").build();
        var address = Address.builder().city("Leeds").postalZipCode("123456").street("Bridge Quarter").build();
        user.addAddress(address);
        System.out.println(user);
    }

}
