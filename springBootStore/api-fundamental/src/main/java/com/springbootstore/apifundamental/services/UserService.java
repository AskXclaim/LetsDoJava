package com.springbootstore.apifundamental.services;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.entities.User;
import com.springbootstore.apifundamental.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements com.springbootstore.apifundamental.services.interfaces.UserService {
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll(String sortBy, PageRequest pageRequest) {
        var reposPageRequest = getReposPageRequest(sortBy, pageRequest);
        var users = userRepository.findAll(reposPageRequest);
        return getUsers(users);
    }

    private static List<User> getUsers(Page<User> users) {
        if (users.isEmpty()) {
            return List.of();
        }
        return users.getContent();
    }

    private static org.springframework.data.domain.PageRequest getReposPageRequest(String sortBy, PageRequest pageRequest) {
        sortBy = getSortBy(sortBy);
        pageRequest = getPageRequest(pageRequest);

        var repoSortBy = Sort.by(Sort.Direction.ASC, sortBy);
        return org.springframework.data.domain.PageRequest.of(
                pageRequest.getPage(), pageRequest.getSize(), repoSortBy);
    }

    private static PageRequest getPageRequest(PageRequest pageRequest) {
        if (pageRequest == null) {
            pageRequest = PageRequest.builder().page(0).size(10).build();
        }
        return pageRequest;
    }

    private static String getSortBy(String sortBy) {
        if (sortBy == null || sortBy.isEmpty() || !Set.of( "name", "email").contains(sortBy) ) {
            sortBy = "username";
        }
        if (sortBy.equals("name")) {
            sortBy = "username";
        }
        return sortBy;
    }
}
