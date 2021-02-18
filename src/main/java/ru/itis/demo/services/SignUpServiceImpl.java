package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.UserForm;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .phone(form.getPhone())
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .build();

        usersRepository.save(newUser);
    }
}
