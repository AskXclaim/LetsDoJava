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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
            return getExceptionCaseResponseEntity(exception);
        }
    }

    @GetMapping("user")
    public ResponseEntity<Response> getUserViaId(@RequestParam(required = true, name = "id") Long id) {
        return this.getUserById(id);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable Long id) {
        try {
            if (id <= 0) {
                return new ResponseEntity<>(getBuild("Please enter a valid user id"), HttpStatus.BAD_REQUEST);
            }
            var response = userService.findById(id).orElse(null);
            if (response == null) {
                return new ResponseEntity<>(getBuild("User not found"), HttpStatus.NOT_FOUND);
            }
            var userDto = userMapper.userToUserDto(response);
            return new ResponseEntity<>(getBuild(userDto), HttpStatus.OK);

        } catch (Exception exception) {
            return getExceptionCaseResponseEntity(exception);
        }
    }


    private Response getBuild(Object item) {
        return Response.builder().data(item).build();
    }

    private ResponseEntity<Response> getExceptionCaseResponseEntity(Exception exception) {
        return new ResponseEntity<>(getBuild(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
