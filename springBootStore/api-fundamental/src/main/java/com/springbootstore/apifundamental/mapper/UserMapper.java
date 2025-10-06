package com.springbootstore.apifundamental.mapper;

import com.springbootstore.apifundamental.dtos.users.UserDto;
import com.springbootstore.apifundamental.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "name", source = "username")
    UserDto userToUserDto(User user);
}
