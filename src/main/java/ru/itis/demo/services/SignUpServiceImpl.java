package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.AccountForm;
import ru.itis.demo.models.Account;
import ru.itis.demo.models.Role;
import ru.itis.demo.models.State;
import ru.itis.demo.repositories.AccountsRepository;

import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SmsService smsService;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private MailsService mailsService;

    @Override
    public void signUp(AccountForm form) {
        Account newUser = Account.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .phone(form.getPhoneNumber())
                .role(Role.USER)
                .state(State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        accountsRepository.save(newUser);

        executorService.submit(() -> {

            smsService.sendSms(form.getPhoneNumber(), "Вы зарегистрированы!");
            mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
        });
    }

}
