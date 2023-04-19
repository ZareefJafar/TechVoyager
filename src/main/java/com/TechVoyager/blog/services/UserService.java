package com.TechVoyager.blog.services;

import com.TechVoyager.blog.entities.User;
import com.TechVoyager.blog.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userID);
    UserDto getUserByID(Integer userId);
    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}
