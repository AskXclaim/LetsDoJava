package com.springbootstore.apifundamental.services;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.entities.User;
import com.springbootstore.apifundamental.repositories.UserRepository;
import com.springbootstore.apifundamental.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;

import static com.springbootstore.apifundamental.utilities.RepositoryUtility.getEntities;
import static com.springbootstore.apifundamental.utilities.RequestParams.getReposPageRequest;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
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
        var sortByValues = getSortByValues();
        var reposPageRequest = getReposPageRequest(sortBy, sortByValues, pageRequest);
        var users = userRepository.findAll(reposPageRequest);
        return getEntities(users);
    }

    private LinkedHashSet<String> getSortByValues() {
        var sortByValues = new LinkedHashSet<String>();
        sortByValues.add("name");
        sortByValues.add("email");
        return sortByValues;
    }


    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }


}
