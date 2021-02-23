package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.UserForm;
import ru.itis.demo.models.State;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailsService mailsService;

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .phone(form.getPhone())
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .state(State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        usersRepository.save(newUser);

        mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
    }
}
