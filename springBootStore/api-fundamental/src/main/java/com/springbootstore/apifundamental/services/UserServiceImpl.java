package com.springbootstore.apifundamental.services;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.entities.User;
import com.springbootstore.apifundamental.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.springbootstore.apifundamental.utilities.RequestParams.getReposPageRequest;

@Service
@AllArgsConstructor
public class UserServiceImpl implements com.springbootstore.apifundamental.services.interfaces.UserService {
    private UserRepository userRepository;

    @Override
    public boolean doesAnyUserExist() {
        return userRepository.count() > 0;
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user.getName(), user.getPassword(), user.getEmail());
    }

    @Override
    public Iterable<User> findAll(String sortBy, PageRequest pageRequest) {
        var reposPageRequest = getReposPageRequest(sortBy, pageRequest);
        var users = userRepository.findAll(reposPageRequest);
        return getUsers(users);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }


    private static List<User> getUsers(Page<User> users) {
        if (users.isEmpty()) {
            return List.of();
        }
        return users.getContent();
    }
}
