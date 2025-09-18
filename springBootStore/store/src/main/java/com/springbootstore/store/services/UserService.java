package com.springbootstore.store.services;

import com.springbootstore.store.entities.Address;
import com.springbootstore.store.entities.Profile;
import com.springbootstore.store.entities.User;
import com.springbootstore.store.repositories.ProfileRepository;
import com.springbootstore.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.System.*;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

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
        var addresses = new ArrayList<Address>();
        addresses.add(address);

        var profile = Profile.builder()
                .bio("Happy person").phone("123456789")
                .birthDate(Date.valueOf(LocalDate.of(1990, 9, 12)))
                .build();

        var newUser = User.builder()
                .name("Kola")
                .password("1234")
                .email("somepassword@some.com")
                .profile(profile)
                .addresses(addresses)
                .build();

        userRepository.save(newUser);
//
//
//        newUser.setProfile(profile);
//        profile.setUser(newUser);

//        profileRepository.save(profile);

    }

    @Transactional
    public void showProfileEntity() {
        User user = userRepository.findFirstBy();
        if (user == null)
            addDefaultUser();

        Profile profile = profileRepository.findFirstBy();
        out.println(profile);
    }
}
