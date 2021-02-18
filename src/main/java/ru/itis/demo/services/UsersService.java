package ru.itis.demo.services;

import ru.itis.demo.dto.UserDto;

import java.util.List;


public interface UsersService {
    List<UserDto> getAllUsers();
}
