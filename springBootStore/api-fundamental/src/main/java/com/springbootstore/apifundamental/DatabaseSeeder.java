package com.springbootstore.apifundamental;

import com.springbootstore.apifundamental.entities.User;
import com.springbootstore.apifundamental.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.lang.System.*;

@Component
@AllArgsConstructor
@Profile("dev")
@Order(value = 0)
public class DatabaseSeeder implements CommandLineRunner {

    private UserService userService;

    @Override
    public void run(String... args) {
        try {
            if (!userService.doesAnyUserExist()) {
                out.println("⚡ Seeding default users...");
                var users = getUsers();

                for (User user : users) {
                    userService.addUser(user);
                }

                out.println("✅ Default users created");
            } else {
                out.println("✅ Users already exist. Skipping seeding.");
            }
        } catch (Exception exception) {
            out.println("❌ The following error occurred while trying to seed users: " + exception.getMessage());
        }
    }

    private Iterable<User> getUsers() {
        var userOne = User.builder().name("Test Data One").password("test123").email("testdataone@test.com").build();
        var userTwo = User.builder().name("Test Data Two").password("test234").email("testdatatwo@test.com").build();
        var userThree = User.builder().name("Test Data Three").password("test345").email("testdatathree@test.com").build();

        return Arrays.asList(userOne, userTwo, userThree);
    }
}
