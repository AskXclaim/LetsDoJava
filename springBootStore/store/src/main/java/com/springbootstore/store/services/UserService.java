package com.springbootstore.store.services;

import com.springbootstore.store.entities.Address;
import com.springbootstore.store.entities.Product;
import com.springbootstore.store.entities.Profile;
import com.springbootstore.store.entities.User;
import com.springbootstore.store.repositories.ProductRepository;
import com.springbootstore.store.repositories.ProfileRepository;
import com.springbootstore.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

import static java.lang.System.*;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final ProductRepository productRepository;

    // This is currently not working but should be fixed soonest.
    @Transactional
    public void showUserEntities() {
        User user = userRepository.findFirstBy();
        if (user == null) {
            addDefaultUser();
            user = userRepository.findFirstBy();
        }

        out.println(user);
    }

    private void addDefaultUser() {
        var address = Address.builder()
                .city("Leeds").street("street one")
                .postalZipCode("postal one")
                .build();

        var profile = Profile.builder()
                .bio("Happy person").phone("123456789")
                .birthDate(Date.valueOf(LocalDate.of(1990, 9, 12)))
                .build();

        var newUser = User.builder()
                .name("Kola")
                .password("1234")
                .email("somepassword@some.com")
                .build();

        newUser.addAddress(address);
        newUser.addProfile(profile);
        userRepository.save(newUser);
    }

    @Transactional
    public void showProfileEntity() {
        User user = userRepository.findFirstBy();
        if (user == null)
            addDefaultUser();

        Profile profile = profileRepository.findFirstBy();
        out.println(profile);
    }

    @Transactional
    public void removeUserEntity(long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            out.println("User with id " + id + " has been deleted");
        }
    }

    @Transactional
    public void addProductToFavourite(Long userId,String productName) {
        var productToAdd = productRepository.findByNameIgnoreCase(productName).orElse(null);
        if (productToAdd != null) {
            var user = userRepository.findUserById(userId).orElseThrow(()-> new RuntimeException("User with id " + userId + " not found"));
            if (user != null) {
                user.addToWishlist(productToAdd);
                userRepository.save(user);
                out.println("Product: '" + productToAdd.getName() + "' has been added to favourites");
                out.println(user);
            }else {
                out.println("User with id " + userId + " not found");
            }
        }else{
            out.println("Product with name:'"+productName+"' not found");

        }
    }
}
