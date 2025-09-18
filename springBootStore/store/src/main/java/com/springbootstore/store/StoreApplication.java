package com.springbootstore.store;

import com.springbootstore.store.entities.Address;
import com.springbootstore.store.entities.User;
import com.springbootstore.store.repositories.UserRepository;
import com.springbootstore.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
      var context=  SpringApplication.run(StoreApplication.class, args);
       var service = context.getBean(UserService.class);
        service.showUserEntities();

//        var repository = context.getBean(UserRepository.class);
//
//        var newUser = User.builder()
//                .name("Kola2")
//                .password("1234")
//                .email("somepassword@some2.com")
//                .build();
//
//        repository.save(newUser);
//        var user = User.builder().name("kola").password("admin").build();
//        var address = Address.builder().city("Leeds").postalZipCode("123456").street("Bridge Quarter").build();
//        user.addAddress(address);
//        System.out.println(user);
    }

}
