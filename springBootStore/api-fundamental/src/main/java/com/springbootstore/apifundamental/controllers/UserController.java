package com.springbootstore.apifundamental.controllers;

import com.springbootstore.apifundamental.dtos.responses.Response;
import com.springbootstore.apifundamental.dtos.users.UserDto;
import com.springbootstore.apifundamental.dtos.users.UserRequest;
import com.springbootstore.apifundamental.mapper.UserMapper;
import com.springbootstore.apifundamental.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("/users")
    public ResponseEntity<Response> getUsers(UserRequest request) {
        try {
            var users = userService.findAll(request.getSortBy(), request.getPageRequest());
            var userDtos = new ArrayList<UserDto>();
            users.forEach(user -> userDtos.add(userMapper.userToUserDto(user)));

            return new ResponseEntity<>(getBuild(userDtos), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(getBuild(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Response getBuild(Object users) {
        return Response.builder().data(users).build();
    }
}
