package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.UserDto;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;

import java.util.List;
import static ru.itis.demo.dto.UserDto.*;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }
}
